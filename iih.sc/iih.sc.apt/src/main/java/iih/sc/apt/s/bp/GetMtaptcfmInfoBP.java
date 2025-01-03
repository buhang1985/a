package iih.sc.apt.s.bp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import iih.en.pv.dto.d.OpBasicDTO;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtaptcfmDTO;
import iih.sc.apt.dto.d.OpAptDetailDTO;
import iih.sc.apt.dto.d.OralAptMgrDTO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scaptappl.d.ScaptapplAggDO;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 *
 * @author renzhi
 *
 */
public class GetMtaptcfmInfoBP {

    //性别code
    private static final String SEX_ID_BOY_CODE  = "1";
    private static final String SEX_ID_GIRL_CODE = "2";
    private static final String SEX_ID_UNDECLARED_CODE = "9";
    private static final String SEX_ID_UNKNOWN_CODE = "0";

    //性别汉语
    private static final String SEX_NAME_BOY  = "男";
    private static final String SEX_NAME_GIRL = "女";
    private static final String SEX_NAME_UNDECLARED = "未说明";
    private static final String SEX_NAME_UNKNOWN = "未知";

    public PagingRtnData<MtaptcfmDTO> exec(PaginationInfo pg, QryRootNodeDTO qryDTO) throws BizException {
        if (pg == null) {
            return new PagingRtnData<MtaptcfmDTO>();
        }
        IQrySQLGeneratorService serv = ServiceFinder.find(IQrySQLGeneratorService.class);
        String whereSql = serv.getQueryStringWithDOName(qryDTO, MtaptcfmDTO.class.getName());
        return  this.getData(whereSql,pg);
    }

    /**
     * 获取数据
     * @throws BizException
     */
    @SuppressWarnings("unchecked")
    private PagingRtnData<MtaptcfmDTO> getData(String whereSql,PaginationInfo pg) throws BizException {
        StringBuilder sql = this.getSql();
        if ( !StringUtil.isEmptyWithTrim(whereSql)) {
            sql.append(" WHERE");
            sql.append( whereSql);
            sql.append(" AND APT.FG_CANC = 'N' ");
        }else{
        	sql.append(" WHERE APT.FG_CANC = 'N' ");
        }
        sql.append(" and mt.fg_needcfm = 'Y'");
        sql.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScAptDO(), "apt"));
        PagingServiceImpl<MtaptcfmDTO> pageQryService = new PagingServiceImpl<MtaptcfmDTO>();
        PagingRtnData<MtaptcfmDTO> findByPageInfo = pageQryService.findByPageInfo(new MtaptcfmDTO(), pg, sql.toString(), "", null);
        FArrayList pageData = findByPageInfo.getPageData();
        pageData = this.setSex(pageData);
        this.SetAge(pageData);
        this.setContentOr(pageData);
        findByPageInfo.setPageData(pageData);
        return findByPageInfo;
    }

    /**
	 * 合单医嘱内容修改
	 *
	 * @param DTO
	 * @return
	 * @author yu.b
	 */
	private void setContentOr(FArrayList pageData){
		if(pageData.isEmpty()) {
			return;
		}

		for (Object obj : pageData) {
            if (obj instanceof MtaptcfmDTO ) {
            	MtaptcfmDTO dto = (MtaptcfmDTO) obj;
				StringBuilder sb = new StringBuilder("||");
				LinkedList<String> strs = new LinkedList<String>(Arrays.asList(dto.getApt_name().split("\\|\\|")));
				if(strs.size() <= 2){
					continue;
				}
				strs.remove(0);
				for(String str1 : strs) {
					if(StringUtil.isEmpty(str1)) continue;
					String[] strArr = str1.split("&");
					if(ArrayUtil.isEmpty(strArr)) continue;
					sb.append(strArr[0]);
					if(strArr.length >= 3){
						sb.append(" ");
						sb.append(StringUtil.isEmpty(strArr[3]) ? "" : strArr[3].split("\\|")[0]);
					}
					sb.append(";");

				}
				sb.append("&&&|&&");
				dto.setApt_name(sb.toString());
            }}

	}

    /**
     * 设置性别
     * @param pageData
     */
    private FArrayList setSex(FArrayList pageData) {
        FArrayList arrayList =  new FArrayList();
        int i = 0;
        for (Object object : pageData) {
            if (object instanceof MtaptcfmDTO ) {
                MtaptcfmDTO dto = (MtaptcfmDTO) object;
                String sex = "";
                if (SEX_ID_BOY_CODE.equals(dto.getSd_sex())) {
                    sex = SEX_NAME_BOY;
                }
                if (SEX_ID_GIRL_CODE.equals(dto.getSd_sex())) {
                    sex = SEX_NAME_GIRL;
                }
                if (SEX_ID_UNDECLARED_CODE.equals(dto.getSd_sex())) {
                    sex = SEX_NAME_UNDECLARED;
                }
                if (SEX_ID_UNKNOWN_CODE.equals(dto.getSd_sex())) {
                    sex = SEX_NAME_UNKNOWN;
                }
                dto.setName_sex(sex);
                arrayList.add(dto);
                i++;
            }
        }
        return arrayList;
    }


    /**
     * 获取sql
     * @return
     */
    private StringBuilder getSql() {
        StringBuilder Sql = new StringBuilder();
        Sql.append(" SELECT");
        Sql.append(" rownum as num,");
        Sql.append(" PAT.ID_PAT,");//患者id
        Sql.append(" MT.ID_APTMT AS ID_APTMT,");//
        Sql.append(" RES_DOC.NAME AS RES_NAME,");//申请医生
        Sql.append(" RES_DOC.ID_PSNDOC AS ID_RES,");//申请医生id
        Sql.append(" PAT.NAME AS PAT_NAME,");//患者姓名
        Sql.append(" PAT.CODE AS  PAT_CODE,");//患者编码
        Sql.append(" PAT.ID_SEX AS ID_SEX,");//性别id
        Sql.append(" PAT.SD_SEX AS SD_SEX,");//性别code
        Sql.append(" PAT.DT_BIRTH AS DT_BIRTH,");//出生日期
        Sql.append(" APPL.CONTENT_OR AS APT_NAME,");//申请单
        Sql.append(" APPL.APPLYNO AS CODE_APPL,");//申请编码
        Sql.append(" APT.DT_B AS DT_B,");//预约时间
        Sql.append(" APPL.ID_EMP_APPL,");//预约申请人
        Sql.append(" DOC_APPL.NAME AS NAME_EMP_APPL,");//预约申请人
        Sql.append(" MT.FG_APTCFM AS FG_APTCFM,");//预约确认标识
        Sql.append(" DOC_MT.NAME AS NAME_EMP_CFM,");//确认人
        Sql.append(" MT.ID_EMP_CFM AS  ID_EMP_CFM,");//确认人
        Sql.append(" APT.QUENO AS APT_QUENO,");//票号
        Sql.append(" DEP.NAME AS NAME_DEP_APPL,");//申请科室
        Sql.append(" DEP_APPL.NAME AS NAME_DEP_SC,");//执行科室
        Sql.append(" SCPL.NAME AS NAME_SCRES,");//排班服务
        Sql.append(" APT.DT_APPT AS DT_APPL_APT,");//预约操作时间
        Sql.append(" MT.DT_APT_CFM AS DT_APPL_MT,");//确认时间
        Sql.append(" apt.id_apt as id_scapt");
        Sql.append(" FROM SC_APT APT");
        Sql.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT = APT.ID_PAT");
        Sql.append(" INNER JOIN SC_APT_MT MT ON MT.ID_APT = APT.ID_APT");
        Sql.append(" INNER JOIN SC_APT_APPL APPL ON APPL.Id_Scapt = apt.id_apt");
        Sql.append(" INNER JOIN  BD_PSNDOC DOC_APPL ON DOC_APPL.ID_PSNDOC = APPL.ID_EMP_APPL");
        Sql.append(" LEFT JOIN  BD_PSNDOC DOC_MT ON DOC_MT.ID_PSNDOC = MT.ID_EMP_CFM");//确认人
        Sql.append(" INNER JOIN BD_DEP DEP ON DEP.ID_DEP = APPL.ID_DEP_APPL");
        Sql.append(" INNER JOIN SC_SCH SCH ON SCH.ID_SCH =  APT.ID_SCH");//排班sc_res
        Sql.append(" INNER JOIN SC_PL SCPL ON SCPL.ID_SCPL = SCH.ID_SCPL");
        Sql.append(" LEFT JOIN BD_PSNDOC RES_DOC ON RES_DOC.ID_PSNDOC = APPL.ID_EMP_APPL");
        Sql.append(" LEFT JOIN BD_DEP DEP_APPL  ON DEP_APPL.ID_DEP = MT.ID_DEP_MP");//执行科室

        return Sql;
    }

    /**
     * 设置年龄
     */
    private FArrayList SetAge(FArrayList pageData) {
        FArrayList arrayList =  new FArrayList();
        for (Object object : pageData) {
            if (object instanceof MtaptcfmDTO ) {
                MtaptcfmDTO dto = (MtaptcfmDTO) object;
                FDate dt_birth = dto.getDt_birth();
                FDate fDate = new FDate();
                int age = fDate.getDaysAfter(dt_birth)/365;
                dto.setAge(age+"");
                arrayList.add(dto);
            }
        }
        return arrayList;
    }

}
