package iih.en.doc.s.bp.preg.qry;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.en.comm.ep.UdiDocEP;
import iih.en.comm.validator.EnValidator;
import iih.en.doc.pregdoc.dto.d.PregDocDTO;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 
 * @author renzhi
 *
 */
public class GetPatDocBP {

    /**
     * 根据患者id 获取患者基本信息
     * 
     * @param patId
     * @return
     * @throws BizException
     */
    public PregDocDTO exec(String patId) throws BizException {
        if (EnValidator.isEmpty(patId)) {
            return null;
        }
        return this.getPatDo(patId);
    }

    /**
     * 根据患者id拼接查询条件
     * 
     * @param patId
     * @return
     * @throws BizException
     */
    private PregDocDTO getPatDo(String patId) throws BizException {
        StringBuilder sqlSb = this.GetSql();
        SqlParam param = new SqlParam();
        if (patId != null) {
            sqlSb.append(" AND PAT.ID_PAT = ?");
            param.addParam(patId);
        }
        PregDocDTO queryDate = this.getPregDocDTO(sqlSb, param);
        this.setUdidocList(queryDate);
        return queryDate;
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

    /**
     * 执行SQL
     * 
     * @param sqlSb
     * @param param
     * @return
     * @throws DAException
     */
    @SuppressWarnings("unchecked")
    private PregDocDTO getPregDocDTO(StringBuilder sqlSb, SqlParam param) throws DAException {
        List<PregDocDTO> list = (List<PregDocDTO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(PregDocDTO.class));
        if (EnValidator.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    /**
     * 拼接SQL
     * 
     * @return
     */
    private StringBuilder GetSql() {
        StringBuilder sqlSb = new StringBuilder();
        sqlSb.append(" SELECT");
        sqlSb.append(" PAT.ID_PAT, "); // 患者id
        sqlSb.append(" PAT.CODE CODE_PAT, "); // 患者编码
        sqlSb.append(" PAT.ID_IDTP, "); // 证件类型
        sqlSb.append(" PAT.ID_CODE ID, "); // 证件号码
        sqlSb.append(" PAT.MOB TEL_ADMDIV, "); // 家庭电话
        sqlSb.append(" PAT.ID_SEX, "); // 性别主键
        sqlSb.append(" ADDR.STREET ADDR_PAT,"); // 家庭地址
        sqlSb.append(" PATCA.NAME  NAME_PATCA "); // 患者分类
        sqlSb.append(" FROM PI_PAT PAT "); // 患者表
        sqlSb.append(" LEFT JOIN PI_PAT_ADDR ADDR ON ADDR.ID_PAT = PAT.ID_PAT "); // 地址表
        sqlSb.append(" LEFT JOIN PI_PAT_CA PATCA ON PAT.ID_PATICATE = PATCA.ID_PATCA "); // 患者分类
        sqlSb.append(" WHERE ADDR.SD_ADDRTP = '9' ");
        return sqlSb;
    }

}
