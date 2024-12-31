package iih.ci.pre.obspre.s.bp;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.srv.dto.d.PhySignDTO;
import iih.ci.pre.dto.d.EmergPreDTO;
import iih.en.pv.enres.d.EnExtDO;
import iih.en.pv.enres.i.IEnextRService;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.utils.params.EnParamsUtil;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 预检信息初始化（身高，体重）
 * 
 * @author liubin
 *
 */
public class ObsPreInitBP {
	/**
	 * 预检信息初始化（身高，体重）
	 * 
	 * @param emergPre
	 * @throws BizException
	 */
	public void exec(EmergPreDTO emergPre, String depId) throws BizException{
		if(emergPre == null || StringUtil.isEmptyWithTrim(emergPre.getId_ent()) || emergPre.getSrvarray() == null || emergPre.getSrvarray().size() <=0)
			return;
		int days = EnParamsUtil.EN000170(depId);
		if(days <= 0)
			return;
		EnExtDO[] exts = getAllExtDos(emergPre.getId_ent(), days);
		if(ArrayUtil.isEmpty(exts))
			return;
		FDouble weight = getLastWeight(exts);
		FDouble height = getLastHeight(exts);
		//体重g服务
		String srvIdWeihtG = EnParamsUtil.MPNR0109();
		//体重kg服务
		String srvIdWeihtKG = EnParamsUtil.MPNR0114();
		//身高cm服务
		String srvIdHeight = EnParamsUtil.MPNR0113();
		for(Object obj : emergPre.getSrvarray()){
			PhySignDTO phy=(PhySignDTO) obj;
			if(StringUtil.isEmptyWithTrim(phy.getId_srv()) || !StringUtil.isEmptyWithTrim(phy.getVal0()))
				continue;
			if(phy.getId_srv().equals(srvIdWeihtG) && weight != null){
				phy.setVal0(weight.multiply(1000).toString());
				continue;
			}
			if(phy.getId_srv().equals(srvIdWeihtKG) && weight != null){
				phy.setVal0(weight.toString());
				continue;
			}
			if(phy.getId_srv().equals(srvIdHeight) && height != null){
				phy.setVal0(height.toString());
				continue;
			}
		}
	}
	/**
	 * 获取最近一次
	 * 
	 * @param entId
	 * @param days
	 * @return
	 * @throws BizException
	 */
	private EnExtDO[] getAllExtDos(String entId, int days) throws BizException {
		DAFacade daf = new DAFacade();
		List<OutpatientDO> ops = (List<OutpatientDO>) daf.findByAttrValString(OutpatientDO.class, OutpatientDO.ID_ENT, entId, new String[]{OutpatientDO.ID_ENT, OutpatientDO.SD_STATUS});
		if(ListUtil.isEmpty(ops))
			return null;
		//诊毕患者不查询历史信息
		if(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH.equals(ops.get(0).getSd_status()))
			return null;
		PatiVisitDO pv = (PatiVisitDO) daf.findByPK(PatiVisitDO.class, entId, new String[]{PatiVisitDO.ID_ENT, PatiVisitDO.ID_PAT});
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT ID_ENTEXT ");
		sqlBuilder.append(" FROM( ");
		sqlBuilder.append(" SELECT EXT.ID_ENTEXT,NVL(NVL(EN.DT_END, EN.DT_ACPT),EN.DT_ENTRY) AS DT_EXT ");
		sqlBuilder.append(" FROM EN_ENT_EXT EXT ");
		sqlBuilder.append(" INNER JOIN EN_ENT EN ON EXT.ID_ENT = EN.ID_ENT ");
		sqlBuilder.append(" WHERE EN.FG_CANC = 'N' ");
		sqlBuilder.append(" AND EN.ID_PAT = ? ");
		sqlBuilder.append(" ) T ");
		sqlBuilder.append(" WHERE T.DT_EXT >= ? ");
		sqlBuilder.append(" ORDER BY T.DT_EXT DESC ");
		SqlParam param = new SqlParam();
		param.addParam(pv.getId_pat());
		param.addParam(ServiceFinder.find(TimeService.class).getUFDateTime().getDateTimeBefore(days));
		List<String>  list = (List<String>) daf.execQuery(sqlBuilder.toString(), param, new ColumnListHandler());
		if(ListUtil.isEmpty(list))
			return null;
		IEnextRService rServ = ServiceFinder.find(IEnextRService.class);
		return rServ.findByIds(list.toArray(new String[0]), FBoolean.FALSE);
	}
	/**
	 * 获取最近有效的体重
	 * 
	 * @param exts
	 * @return
	 */
	private FDouble getLastWeight(EnExtDO[] exts){
		for(EnExtDO ext : exts){
			if(ext.getWeight() != null)
				return ext.getWeight();
		}
		return null;
	}
	/**
	 * 获取最近有效的身高
	 * 
	 * @param exts
	 * @return
	 */
	private FDouble getLastHeight(EnExtDO[] exts){
		for(EnExtDO ext : exts){
			if(ext.getHeight() != null)
				return ext.getHeight();
		}
		return null;
	}
}
