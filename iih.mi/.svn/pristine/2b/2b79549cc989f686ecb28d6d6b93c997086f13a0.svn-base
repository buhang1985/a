package iih.mi.biz.s.hpsign.bp;

import java.util.List;

import iih.mi.biz.dto.d.MiBizType;
import iih.mi.biz.signinfo.dto.d.MiSignInfoDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取签到信息
 * @author yangyang
 * @date 2018-05-07
 */
public class GetHpSignArrayBp {
	
	/**获取签到信息
	 * @return
	 * @throws BizException
	 */
	public MiSignInfoDTO[] exec(String empId, String id_hp, String bizType) throws BizException
	{
		//1、参数校验
		validateParam(empId,id_hp,bizType);
		Integer intBizType=0;
		if(MiBizType.OEP.equals(bizType) )
		{
			intBizType=0;
		}
		else{
			intBizType=1;
		}
		//2、查询服务
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT SIGNIN.ID_HP,SIGNIN.ID_EMP,PSN.NAME,SIGNIN.CODE_BUSINESS,SIGNIN.EU_BIZTYPE,");
        sql.append(" SIGNIN.DT_B,SIGNIN.DT_E,SIGNIN.FG_ACTIVE,BDHP.NAME AS NAME_HP");
        sql.append(" FROM MI_HP_SIGN_IN SIGNIN LEFT JOIN BD_PSNDOC PSN ON SIGNIN.ID_EMP = PSN.ID_PSNDOC");
        sql.append(" INNER JOIN BD_HP BDHP ON SIGNIN.ID_HP=BDHP.ID_HP");
        sql.append(" where 1=1 AND SIGNIN.FG_ACTIVE='Y' AND SIGNIN.ID_EMP=? AND SIGNIN.ID_HP=? AND SIGNIN.EU_BIZTYPE=?");
        DAFacade facade=new DAFacade();
        SqlParam param=new SqlParam();
        param.addParam(empId);
        param.addParam(id_hp);
        param.addParam(intBizType);
        List<MiSignInfoDTO> signInfoDtoArr=(List<MiSignInfoDTO>)facade.execQuery(sql.toString(), param,new BeanListHandler(MiSignInfoDTO.class));
		return signInfoDtoArr.toArray(new MiSignInfoDTO[0]);
	}
	private void validateParam(String empId, String id_hp, String bizType) throws BizException
	{
		if(xap.lui.core.xml.StringUtils.isEmpty(empId))
			throw new BizException("获取签到记录参数错误，id_emp不能为空!");
		if(xap.lui.core.xml.StringUtils.isEmpty(id_hp))
			throw new BizException("获取签到记录参数错误，id_hp不能为空!");
		if(xap.lui.core.xml.StringUtils.isEmpty(bizType))
			throw new BizException("获取签到记录参数错误，bizType不能为空!");
	}
}
