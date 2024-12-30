package iih.sc.apt.out.cmd.bp;

import java.util.List;

import org.apache.commons.lang3.BooleanUtils;

import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.i.IScAptCmdService;
import iih.sc.apt.out.ci.d.MtAptResDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class SaveAutoApt4CiBP {
	
	public MtAptResDTO exec(MtAppDTO appDTO) throws BizException
	{
		//校验数据
		MtAptResDTO mtAptResDTO = this.ValidData(appDTO);
		if(!mtAptResDTO.getSuccess().booleanValue())
		{
			return mtAptResDTO;
		}
		//查询数据,没有数据返回失败
		MtAppDTO mtAppDTO = this.getAppl(appDTO);
		if(mtAppDTO == null)
		{
			mtAptResDTO = new MtAptResDTO();
			mtAptResDTO.setSuccess(FBoolean.FALSE);
			mtAptResDTO.setError_msg("预约失败:未找到申请单信息,id_or="+appDTO.getId_or());
			return mtAptResDTO;
		}
		//医技预约保存
		mtAppDTO.setId_scchl(appDTO.getId_scchl());//渠道
		mtAppDTO.setOut_flag(appDTO.getOut_flag());//第三方标识  true:第三方   fasle:iih
		IScAptCmdService iScAptCmdService = ServiceFinder.find(IScAptCmdService.class);
		MtResDTO mtresdto = new MtResDTO();
		mtresdto.setId_dep(mtAppDTO.getId_dep_mp());
		mtresdto.setId_scchl(appDTO.getId_scchl());
		MtResDTO rResDTO = null ;
		try
		{
			rResDTO = iScAptCmdService.saveAutoMtApt(mtresdto, mtAppDTO);
		}
		catch(BizException  e)
		{
			mtAptResDTO = new MtAptResDTO();
			mtAptResDTO.setSuccess(FBoolean.FALSE);
			mtAptResDTO.setError_msg("预约失败:"+e.getMessage());
			return mtAptResDTO;
		}
		
		if(rResDTO == null)
		{
			mtAptResDTO = new MtAptResDTO();
			mtAptResDTO.setSuccess(FBoolean.FALSE);
			mtAptResDTO.setError_msg("预约失败:未抛出异常,未返回预约数据");
			return mtAptResDTO;
		}
		mtAptResDTO.setApt_time(new FDateTime(rResDTO.getD_sch() ,rResDTO.getT_b_acpt())); 
		return mtAptResDTO;
	}
	
	/**
	 * 根据医嘱id查询申请单,如果没有数据或多条数据返回预约失败
	 * @param appDTO
	 * @return
	 * @throws DAException 
	 */
	private MtAppDTO getAppl(MtAppDTO appDTO) throws DAException
	{
		MtAptResDTO resDTO = new MtAptResDTO();
		StringBuilder sql = new StringBuilder();
		sql.append(" select appl.id_dep_mp,");
		sql.append(" appl.id_srv,");
		sql.append(" appl.dt_appl,");
		sql.append(" appl.id_or,");
		sql.append(" appl.name        as Name_or,");
		sql.append(" ent.id_entp,");
		sql.append(" appl.id_dep_appl,");
		sql.append(" appl.id_ent,");
		sql.append(" appl.id_sex,");
		sql.append(" appl.fg_urgent,");
		sql.append(" appl.d_b         as Dt_plan");
		sql.append(" from sc_apt_appl appl");
		sql.append(" inner join en_ent ent");
		sql.append(" on ent.id_ent = appl.id_ent");
		sql.append(" where appl.id_or = ?");
		sql.append(" and appl.fg_comfirm  = 'N' ");
		SqlParam param = new SqlParam();
		param.addParam(appDTO.getId_or());
		MtAppDTO mtAppDTO = (MtAppDTO) new DAFacade().execQuery(sql.toString(), param,
				new BeanHandler(MtAppDTO.class));
		return mtAppDTO;
	}
	
	/**
	 * 校验入参
	 * @param appDTO
	 * @return
	 */
	private MtAptResDTO ValidData(MtAppDTO appDTO)
	{
		MtAptResDTO resDTO = new MtAptResDTO();
		resDTO.setSuccess(FBoolean.TRUE);
		resDTO.setError_msg("");
		if(appDTO == null)
		{
			resDTO.setSuccess(FBoolean.FALSE);
			resDTO.setError_msg("预约失败：入参为null");
			return resDTO;
		}
		if(StringUtil.isEmpty(appDTO.getId_or()))
		{
			resDTO.setSuccess(FBoolean.FALSE);
			resDTO.setError_msg("预约失败：医嘱id(id_or)为空");
			return resDTO;
		}
		if(StringUtil.isEmpty(appDTO.getId_scchl()))
		{
			resDTO.setSuccess(FBoolean.FALSE);
			resDTO.setError_msg("预约失败：渠道为空(id_scchl)为空");
			return resDTO;
		}
		if(appDTO.getOut_flag() == null)
		{
			resDTO.setSuccess(FBoolean.FALSE);
			resDTO.setError_msg("预约失败：第三方标识为空(out_flag)为空");
			return resDTO;
		}
		return resDTO;
	}
}
