package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.i.external.provide.ICiOrdEnService;
import iih.ci.ord.i.external.provide.meta.en.Mode4CheckExistValidOrdersEnum;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnErUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 退号校验
 * 
 * @author liubin
 *
 */
public class CancOpRegValidateBP {
	/**
	 * 退号校验
	 * 
	 * @param entId
	 * @throws BizException
	 */
	public void exec(String entId) throws BizException {
		//1.校验挂号是否已经取消
		PatiVisitDO pv = this.validatePv(entId);
		//2.校验是否存在已付费医嘱
		this.validateBl(entId);
		//3.急诊号校验
		this.validateEr(pv);
	}
	/**
	 * 校验挂号是否已经取消
	 * 
	 * @param entId
	 * @throws BizException
	 */
	private PatiVisitDO validatePv(String entId) throws BizException{
		PvEP ep = new PvEP();
		PatiVisitDO pv = ep.getPvById(entId);
		if(pv==null){
			throw new BizException(IEnMsgConst.ERROR_OP_PVINFO_NOT_EXISTS);
		}
		if(FBoolean.TRUE.equals(pv.getFg_canc())){
			throw new BizException(IEnMsgConst.ERROR_OP_REG_HAS_CANCED);
		}
		return pv;
	}
	/**
	 * 校验是否存在已付费医嘱
	 * 
	 * @param entId
	 * @throws BizException
	 */
	private void validateBl(String entId) throws BizException {
		ICiOrdEnService serv = ServiceFinder.find(ICiOrdEnService.class);
		FBoolean result = serv.isExistValidOrders(entId, Mode4CheckExistValidOrdersEnum.ORDERSTATUS2);
		if (FBoolean.TRUE.equals(result)) {
			throw new BizException("患者当前存在已付费医嘱，不可以退号！");
		}
	}
	/**
	 * 急诊退号校验
	 * 
	 * @param pv
	 * @throws BizException
	 */
	private void validateEr(PatiVisitDO pv) throws BizException {
		if(!IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(pv.getCode_entp()))
			return;
		//
		String lastEntId = EnErUtils.getLastEntByEntId(pv.getId_ent());
		if(!pv.getId_ent().equals(lastEntId))
			throw new BizException("该次抢救有多次挂号，请先把最后一次挂号退号！");
		//已经分配床位的第一条就诊记录需要取消入科后进行退号
		if(isFirstInfoWithBed(pv.getId_ent()))
			throw new BizException("已经分配床位的就诊，需要取消入科后才能进行退号！");
	}
	
	/**
	 * 是否是已经分配床位的第一条就诊记录
	 * 
	 * @param endId
	 * @return
	 * @throws BizException
	 */
	private boolean isFirstInfoWithBed(String entId) throws BizException {
		String erPreId = EnErUtils.getPreIdByEntId(entId);
		if(EnValidator.isEmpty(erPreId))
			return false;
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT EN.ID_ENT ");
		sqlBuilder.append(" FROM EN_ENT EN ");
		sqlBuilder.append(" INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sqlBuilder.append(" INNER JOIN EN_ENT_OP_ER OPER ON EN.ID_ENT = OPER.ID_ENT ");
		sqlBuilder.append(" WHERE OPER.ID_ERPRE = ?  ");
		sqlBuilder.append(" AND EN.FG_CANC = 'N' ");
		sqlBuilder.append(" AND NVL(OPER.ID_BED, '~')<>'~' ");
		sqlBuilder.append(" ORDER BY OP.DT_VALID_B, EN.DT_INSERT ");
		String sql = sqlBuilder.toString();
		SqlParam param = new SqlParam();
		param.addParam(erPreId); 
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		return !ListUtil.isEmpty(list) && entId.equals(list.get(0));
	}
}
