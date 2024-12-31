package iih.en.doc.s.bp.preg.qry;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.en.comm.IEnConst;
import iih.en.comm.ep.UdiDocEP;
import iih.en.comm.validator.EnValidator;
import iih.en.doc.pregdoc.dto.d.PregDocDTO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.desc.PatiAddrDODesc;
import iih.pi.reg.pat.i.IPatiAddrDORService;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 内部使用
 * 根据患者获取id建档信息
 * @author renzhi
 *
 */
public class GetPregDocInsideBP {

    /**
     * 根据患者id获取建档信息
     * 
     * @param patId 患者ID
     * @return
     * @throws BizException
     */
    public PregDocDTO exec(String patId) throws BizException {
        // 参数检查
        EnValidator.validateParam("patId", patId);

        // 取得建档信息PregDocDTO
        PregDocDTO pregDocDTO = gePregDocDTO(patId);
        if (null == pregDocDTO) {
            return pregDocDTO;
        }

        // 设置患者年龄
        pregDocDTO.setAge_pat(AgeCalcUtil.getAge(pregDocDTO.getDt_birth()));

        // 设置患者联系人参照名称
        pregDocDTO.setName_patcontref(pregDocDTO.getName_patcont());

        // 根据患者信息设置用户地址
        getPatAddrInfo4PregDocDTO(patId, pregDocDTO);

        // 设置自定义档案的值
        setUdidocList(pregDocDTO);

        // 如果预约日期为null,直接返回
        if (pregDocDTO.getD_expect() == null) {
            return pregDocDTO;
        }

        return pregDocDTO;
    }


    
    /**
     * 查询数据
     * 
     * @param patId
     * @return
     * @throws BizException
     */
    private PregDocDTO gePregDocDTO(String patId) throws BizException {
        StringBuilder sqlSb = new StringBuilder();
        sqlSb.append(" select doc.id_entdoc,"); // 建档主键
        sqlSb.append(" doc.id_pat,"); // 患者ID
        sqlSb.append(" doc.name_pat,"); // 患者姓名
        sqlSb.append(" doc.sd_sex,"); // 性别编码
        sqlSb.append(" doc.id_sex,"); // 性别主键
        sqlSb.append(" doc.dt_birth_pat  dt_birth,"); // 出生日期
        sqlSb.append(" doc.telno_pat  tel_admdiv,"); // 现住址电话
        sqlSb.append(" doc.sd_admdiv_addr  sd_admdiv,"); // 现住址区县码
        sqlSb.append(" doc.addr_pat,"); // 现住址
        sqlSb.append(" adminarea.fullname  name_admdiv_husb,"); // 配偶户籍码名称
        sqlSb.append(" preg.id_pregdoc,"); // 产科建档ID
        sqlSb.append(" preg.id_admdiv_husb,"); // 配偶户籍码ID
        sqlSb.append(" preg.sd_admdiv_husb,"); // 配偶户籍码
        sqlSb.append(" preg.fg_born_here,"); // 本院分娩
        sqlSb.append(" preg.d_last_menst,"); // 末次月经日期
        sqlSb.append(" preg.d_expect,"); // 预产期
        sqlSb.append(" preg.dt_appt,"); // 预约日期
        sqlSb.append(" preg.dt_doc,"); // 建档日期
        sqlSb.append(" preg.eu_status,"); // 档案状态
        sqlSb.append(" preg.id_patcont,"); // 患者联系人ID
        sqlSb.append(" cont.id_conttp,"); // 联系人类型ID
        sqlSb.append(" cont.sd_conttp,"); // 联系人类型码
        sqlSb.append(" cont.name  name_patcont,"); // 联系人姓名
        sqlSb.append(" cont.conttel,"); // 联系人电话
        sqlSb.append(" cont.contaddr,"); // 联系人地址
        sqlSb.append(" pat.id_paticate  id_patca,"); // 患者分类ID
        sqlSb.append(" pat.id_patpritp  id_pripat,"); // 患者价格分类ID
        sqlSb.append(" pat.id_patcrettp  id_patcret,"); // 患者信用分类ID
        sqlSb.append(" pat.code code_pat,"); // 患者code
        sqlSb.append(" pat.sd_idtp,"); // 证件类型码
        sqlSb.append(" pat.id_idtp,"); // 证件类型码主键
        sqlSb.append(" pat.id_code  id,"); // 证件号码
        sqlSb.append(" pat.photo,"); // 照片
        sqlSb.append(" pat.workunit  workplace,"); // 工作单位
        sqlSb.append(" patca.name  name_patca,"); // 患者分类名称
        sqlSb.append(" patcret.name  name_patcret,"); // 患者信用分类名称
        sqlSb.append(" pripat.name  name_pripat"); // 患者价格分类名称
        sqlSb.append(" FROM en_doc_preg preg"); // 患者基本信息表
        sqlSb.append(" left join EN_DOC doc on doc.id_entdoc = preg.id_entdoc "); // 就诊档案表
        sqlSb.append(" left join pi_pat pat on doc.id_pat = pat.id_pat"); // 就诊建档_产妇表
        sqlSb.append(" left join PI_PAT_CA patca on pat.id_paticate = patca.id_patca"); // 患者分类表
        sqlSb.append(" left join PI_PAT_CRET  patcret on pat.id_patcrettp = patcret.id_patcret"); // 患者信用分类表
        sqlSb.append(" left join BD_PRI_PAT pripat on pat.id_patpritp = pripat.id_pripat"); // 患者价格分类表
        sqlSb.append(" left join BD_ADMINAREA adminarea on adminarea.code = preg.sd_admdiv_husb"); // 行政区划表
        sqlSb.append(" left join PI_PAT_CONT cont on preg.id_patcont = cont.id_patcont"); // //患者联系人表
        sqlSb.append("  where pat.id_pat = ?");
        SqlParam param = new SqlParam();
        param.addParam(patId);
        sqlSb.append(" and preg.EU_STATUS IN(?,?)");
        param.addParam(IEnConst.STATE_RESERVE);
        param.addParam(IEnConst.STATE_DOC);
        @SuppressWarnings("unchecked")
        List<PregDocDTO> list = (List<PregDocDTO>) new DAFacade().execQuery(sqlSb.toString(), param,
                new BeanListHandler(PregDocDTO.class));
        if (EnValidator.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    /**
     * 查找用户地址相关信息
     * 
     * @param patId
     * @param pregDocDTO
     * @throws BizException
     */
    private void getPatAddrInfo4PregDocDTO(String patId, PregDocDTO pregDocDTO) throws BizException {
        IPatiAddrDORService addRService = ServiceFinder.find(IPatiAddrDORService.class);
        PatiAddrDO[] patAddrDOArr = addRService.find(PatiAddrDODesc.TABLE_ALIAS_NAME + ".id_pat ='" + patId + "'", "",
                FBoolean.FALSE);
        if (EnValidator.isEmpty(patAddrDOArr)) {
            return;
        }
        for (PatiAddrDO addrPatDO : patAddrDOArr) {
            // 现住址
            if (!EnValidator.isEmpty(addrPatDO.getId_addrtp())
                    && addrPatDO.getId_addrtp().equals(IPiDictCodeConst.ID_ADDR_TYPE_NOW)) {
                pregDocDTO.setName_admdiv(addrPatDO.getAdmdiv_name());
                pregDocDTO.setId_admdiv(addrPatDO.getId_admdiv());
                pregDocDTO.setTel_admdiv(addrPatDO.getTel());
                pregDocDTO.setPostcode_addr(addrPatDO.getZip());
            }
            // 户口地址
            if (!EnValidator.isEmpty(addrPatDO.getId_addrtp())
                    && addrPatDO.getId_addrtp().equals(IPiDictCodeConst.ID_ADDR_TYPE_CENCUS)) {
                pregDocDTO.setId_admdiv_resi(addrPatDO.getId_admdiv());
                pregDocDTO.setSd_admdiv_resi(addrPatDO.getSd_admdiv());
                pregDocDTO.setName_admdiv_resi(addrPatDO.getAdmdiv_name());
                pregDocDTO.setAddr_resi(addrPatDO.getStreet());
                pregDocDTO.setPostcode_resi(addrPatDO.getZip());
            }
            // 工作地址
            if (!EnValidator.isEmpty(addrPatDO.getId_addrtp())
                    && addrPatDO.getId_addrtp().equals(IPiDictCodeConst.ID_ADDR_TYPE_WORK)) {
                pregDocDTO.setId_admdiv_work(addrPatDO.getId_admdiv());
                pregDocDTO.setSd_admdiv_work(addrPatDO.getSd_admdiv());
                pregDocDTO.setName_admdiv_work(addrPatDO.getAdmdiv_name());
                pregDocDTO.setAddr_work(addrPatDO.getStreet());
                pregDocDTO.setPostcode_work(addrPatDO.getZip());
                pregDocDTO.setTel_work(addrPatDO.getTel());
            }
        }
    }

    /**
     * 设置自定义档案的值
     * 
     * @param pregDocDTO
     * @throws BizException
     */
    @SuppressWarnings("unchecked")
    private void setUdidocList(PregDocDTO pregDocDTO) throws BizException {
        UdiDocEP docEp = new UdiDocEP();
        FArrayList idlist = new FArrayList();
        idlist.add(IPiDictCodeConst.SD_PAT_REL_TYPE_DOCLIST);
        idlist.add(IPiDictCodeTypeConst.SD_IDTP);
        idlist.add(IPiDictCodeTypeConst.SD_SEX_CODE);

        Map<String, UdidocDO> map = docEp.getUdiDocsByCodes(idlist);
        if (EnValidator.isEmpty(map)) {
            return;
        }
        // 性别
        if (map.get(pregDocDTO.getId_sex()) != null) {
            pregDocDTO.setName_sex(map.get(pregDocDTO.getId_sex()).getName());
        }
        // 证件类型
        if (map.get(pregDocDTO.getId_idtp()) != null) {
            pregDocDTO.setName_idtp(map.get(pregDocDTO.getId_idtp()).getName());
        }
        // 联系人类型
        if (map.get(pregDocDTO.getId_conttp()) != null) {
            pregDocDTO.setName_conttp(map.get(pregDocDTO.getId_conttp()).getName());
        }
    }
}
