package iih.bl.cg.blcgquery.s.rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.dto.accsrvrelat.d.AccSrvRelatDTO;
import iih.bd.pp.i.IBdPpQryService;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.params.BlParams;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 住院记账表插入前规则
 * 1.住院记账流水号补充
 * 2.记账人员补漏
 * 3.处理核算项目分类赋值
 * 4.记账操作时间设值
 * 
 * @author xy.zhou
 * @version ly 2018/05/14 重构
 * @version ly 2018/05/20 添加fg_selfpay字段赋值 -->新记账逻辑支持，删除 2018/08/12 ly
 * @version ly 2018/05/30 记账操作时间设值  -->新记账逻辑支持，删除 2018/08/12 ly
 */
public class BlCgIpInsertBefRule implements IRule<BlCgIpDO> {

	@Override
	public void process(BlCgIpDO... dos) throws BizException {
		
		List<String> srvIdList = new ArrayList<>();
		List<String> orsrvIdList = new ArrayList<>();
		for (BlCgIpDO itm : dos) {
			if(!srvIdList.contains(itm.getId_srv())){
				srvIdList.add(itm.getId_srv());
			}
			
			if(!StringUtil.isEmpty(itm.getId_orsrv()) && !orsrvIdList.contains(itm.getId_orsrv())){
				orsrvIdList.add(itm.getId_orsrv());
			}
		}
		
		
		//获取住院记账流水号
		IBillcodeManage iBillcodeManage = ServiceFinder.find(IBillcodeManage.class);
		String[] strings = iBillcodeManage.getBatchBillCodes_RequiresNew(BlCgIpDO.class.getName(),dos[0], dos.length);
		
		//取得核算关系
		Map<String,AccSrvRelatDTO> relMap = this.getAcSrvRelat(srvIdList.toArray(new String[0]));
		
		//取得医嘱服务自费标识
		//Map<String,FBoolean> orsrvMap = this.getOrsrvFgSlefpay(orsrvIdList.toArray(new String[0]));
		
		FDateTime now = AppUtils.getServerDateTime();
		for (int i = 0; i < strings.length; i++) {
			dos[i].setCode_cg(strings[i]);
			/*if(StringUtil.isEmpty(dos[i].getId_emp_cg())){
				dos[i].setId_emp_cg(Context.get().getStuffId());
			}*/
			
			AccSrvRelatDTO relDto = relMap.get(dos[i].getId_srv());
			if(relDto != null){
				dos[i].setCode_account(relDto.getCode_acc());
				dos[i].setName_account(relDto.getName_acc());
			}
			
			/*if(!StringUtil.isEmpty(dos[i].getId_orsrv()) && orsrvMap.containsKey(dos[i].getId_orsrv())){
				dos[i].setFg_selfpay(orsrvMap.get(dos[i].getId_orsrv()));
			}else{
				dos[i].setFg_selfpay(FBoolean.TRUE);
			}*/
			
			//dos[i].setDt_oper_cg(now);
		}
		
		//约束记账时间
		if(FBoolean.FALSE.equals(BlParams.BLCG0034())){
			
			String endId = dos[0].getId_ent();
			DAFacade daf = new DAFacade();
			PatiVisitDO entDO = (PatiVisitDO)daf.findByPK(PatiVisitDO.class, endId, new String[]{PatiVisitDO.ID_ENT,PatiVisitDO.DT_END});
			
			if(entDO.getDt_end() != null){
				for (BlCgIpDO cgIpDO : dos) {
					if(cgIpDO.getDt_cg().compareTo(entDO.getDt_end()) > 0){
						cgIpDO.setDt_cg(entDO.getDt_end());
					}
				}
			}
		}
	}
	
	/**
	 * 取得核算关系
	 * @param srvIds
	 * @return
	 * @throws BizException
	 */
	private Map<String,AccSrvRelatDTO> getAcSrvRelat(String[] srvIds) throws BizException {
		
		Map<String,AccSrvRelatDTO> map = new HashMap<String,AccSrvRelatDTO>();
		IBdPpQryService ppQryService = ServiceFinder.find(IBdPpQryService.class);
		AccSrvRelatDTO[] relDtos = ppQryService.getAccSrvRelat(srvIds, IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		if(ArrayUtil.isEmpty(relDtos)){
			return map;
		}
		
		for (AccSrvRelatDTO dto : relDtos) {
			map.put(dto.getId_srv(), dto);
		}
		
		return map;
	}

	/**
	 * 取得医嘱服务自费标识
	 * @param orsrvIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	private Map<String,FBoolean> getOrsrvFgSlefpay(String[] orsrvIds) throws BizException {
		
		Map<String,FBoolean> map = new HashMap<String,FBoolean>();
		
		if(ArrayUtil.isEmpty(orsrvIds))
			return map;
		
		DAFacade daf = new DAFacade();
		String[] fields = new String[]{OrdSrvDO.ID_ORSRV,OrdSrvDO.FG_SELFPAY};
		List<OrdSrvDO> dos = (List<OrdSrvDO>)daf.findByPKs(OrdSrvDO.class, orsrvIds, fields);
		
		if(!ListUtil.isEmpty(dos)){
			for (OrdSrvDO ordSrvDO : dos) {
				map.put(ordSrvDO.getId_orsrv(), ordSrvDO.getFg_selfpay());
			}
		}
		
		return map;
	}
}
