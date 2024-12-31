package iih.bd.fc.s.bp.qrymatch;

import java.util.ArrayList;
import java.util.List;

import iih.bd.fc.dto.qrymatch.d.QryMatchCondDTO;
import iih.bd.fc.dto.qrymatch.d.QryRefListDTO;
import iih.bd.fc.i.IOrpltpmtParaService;
import iih.bd.fc.ormatchorpltp.d.OrpltpMatchParamDTO;
import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.bd.fc.orpltpmatch.d.EnumBool;
import iih.bd.fc.s.bp.qrymatch.qry.GetSrvBaseDataSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @Description: 医嘱匹配查询
 * @author: tiancj@founder.com.cn
 * @version：2019年11月21日 下午1:16:28 创建
 */
public class OrptpMatchQueryBp {

	/**
	 * 主入口
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public QryRefListDTO[] exec(QryMatchCondDTO inParam) throws BizException {

		// 1、初始化参数值
		OrpltpMatchParamDTO param = initParam(inParam);

		// 2、闭环匹配
		OrpltpDO[] orpltp = matchQry(param);

		// 3、返回数据组装
		QryRefListDTO[] rtns = pakageRtn(orpltp[0]);

		return rtns;
	}

	
	/**
	 * 参数校验初始化
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private OrpltpMatchParamDTO initParam(QryMatchCondDTO param) throws BizException {
		if (param == null)
			throw new BizException("医嘱闭环匹配查询，参数空异常！");
		if (StringUtil.isEmptyWithTrim(param.getCode_entp()))
			throw new BizException("医嘱闭环匹配查询，必须指定就诊类型！");
		if (StringUtil.isEmptyWithTrim(param.getId_srv()))
			throw new BizException("医嘱闭环匹配查询，必须指定医疗服务！");
		GetSrvBaseDataSql sql = new GetSrvBaseDataSql(param.getId_srv()); //获取医疗服务的基本信息
		OrpltpMatchParamDTO[] rtns = (OrpltpMatchParamDTO[]) AppFwUtil.getDORstWithDao(sql, OrpltpMatchParamDTO.class);
		OrpltpMatchParamDTO rtn = rtns[0];
		rtn.setCode_entp(param.getCode_entp());
		if (!StringUtil.isEmptyWithTrim(param.getId_dep_or()))
			rtn.setId_dep_or(param.getId_dep_or());
		if (!StringUtil.isEmptyWithTrim(param.getId_dep_phy()))
			rtn.setId_dep_phy(param.getId_dep_phy());
		if (!StringUtil.isEmptyWithTrim(param.getId_dep_nur()))
			rtn.setId_dep_nur(param.getId_dep_nur());
//		if (!StringUtil.isEmptyWithTrim(param.getSd_drugdeliverymethod()))
//			rtn.setSd_drugdeliverymethod(param.getSd_drugdeliverymethod());
		if (!StringUtil.isEmptyWithTrim(param.getId_route()))
			rtn.setId_route(param.getId_route());
		// 皮试标识
		setSkinDataValue(getFg_data(param.getFg_skintest()), rtn);
		//在院执行标识
		setMpinDataValue(getFg_data(param.getFg_mp_in()), rtn);
		// 出院带药标识
		setPresDataValue(getFg_data(param.getFg_pres_outp()), rtn);
		// 在院整领标识
		seWholeDataValue(getFg_data(param.getFg_wholepack()), rtn);
		// 退药标识
		seBackDataValue(getFg_data(param.getFg_back()), rtn);
		
		return rtn;
	}

	/**
	 * 校验前台参数 返回值转换
	 * 
	 * @param enums
	 * @return
	 */
	private int getFg_data(Integer enums) {
		if (enums == EnumBool.UNLIMIT)
			return 2;
		if (enums == EnumBool.YES)
			return 1;
		if (enums == EnumBool.NO)
			return 0;
		return 0;
	}

	/**
	 * 皮试FBoolean赋值
	 * 
	 * @param enums
	 * @param rtn
	 */
	private void setSkinDataValue(int enums, OrpltpMatchParamDTO rtn) {
		if (enums == 2)
			rtn.setFg_skintest(null);
		if (enums == 1)
			rtn.setFg_skintest(FBoolean.TRUE);
		if (enums == 0)
			rtn.setFg_skintest(FBoolean.FALSE);
	}

	/**
	 * 在院执行FBoolean赋值
	 * 
	 * @param enums
	 * @param rtn
	 */
	private void setMpinDataValue(int enums, OrpltpMatchParamDTO rtn) {
		if (enums == 2)
			rtn.setFg_mp_in(null);
		if (enums == 1)
			rtn.setFg_mp_in(FBoolean.TRUE);
		if (enums == 0)
			rtn.setFg_mp_in(FBoolean.FALSE);
	}

	/**
	 * 出院带药FBoolean赋值
	 * 
	 * @param enums
	 * @param rtn
	 */
	private void setPresDataValue(int enums, OrpltpMatchParamDTO rtn) {
		if (enums == 2)
			rtn.setFg_pres_outp(null);
		if (enums == 1)
			rtn.setFg_pres_outp(FBoolean.TRUE);
		if (enums == 0)
			rtn.setFg_pres_outp(FBoolean.FALSE);
	}
	
	/**
	 * 在院整领FBoolean赋值
	 * 
	 * @param enums
	 * @param rtn
	 */
	private void seWholeDataValue(int enums, OrpltpMatchParamDTO rtn) {
		if (enums == 2)
			rtn.setFg_wholepack(null);
		if (enums == 1)
			rtn.setFg_wholepack(FBoolean.TRUE);
		if (enums == 0)
			rtn.setFg_wholepack(FBoolean.FALSE);
	}
	
	
	/**
	 * 退药FBoolean赋值
	 * 
	 * @param enums
	 * @param rtn
	 */
	private void seBackDataValue(int enums, OrpltpMatchParamDTO rtn) {
		if (enums == 2)
			rtn.setFg_back(null);
		if (enums == 1)
			rtn.setFg_back(FBoolean.TRUE);
		if (enums == 0)
			rtn.setFg_back(FBoolean.FALSE);
	}

	/**
	 * 匹配
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public OrpltpDO[] matchQry(OrpltpMatchParamDTO param) throws BizException {
		return ServiceFinder.find(IOrpltpmtParaService.class).GetOrpltp(param);
	}

	/**
	 * 返回数据组装
	 * 
	 * @param dtos
	 * @return
	 */
	private QryRefListDTO[] pakageRtn(OrpltpDO rtns) {
		if (rtns == null)
			return null;
		List<QryRefListDTO> reList = new ArrayList<QryRefListDTO>();
		QryRefListDTO qryListDTO = new QryRefListDTO();
		qryListDTO.setId_orpltp(rtns.getId_orpltp());
		qryListDTO.setOrpltp_name(rtns.getName());
		qryListDTO.setOrpltp_des(rtns.getDes());
		reList.add(qryListDTO);
		return reList.toArray(new QryRefListDTO[0]);
	}
}
