package iih.ci.ord.s.bp.ems.save.ip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.i.IFreqdefMDORService;
import iih.bl.params.BlParams;
import iih.ci.ord.ciordems.d.QuantumParamDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorsrvhp.d.CiOrSrvHpDO;
import iih.ci.ord.ciorsrvhp.i.ICiorsrvhpCudService;
import iih.ci.ord.content.d.CiOrIdentifcationInfo;
import iih.ci.ord.dto.validate.EmsValidateRstDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.ExeWhDeptDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.common.CiOrParamUtils;
import iih.ci.ord.s.bp.ems.CiEmsDefaultValueSetBP;
import iih.ci.ord.s.bp.ems.CiOrAggAndRelDatum;
import iih.ci.ord.s.bp.ems.CiOrAttachInfoUtils;
import iih.ci.ord.s.bp.ems.save.validate.BaseSaveValidateBP;
import iih.ci.ord.s.bp.ems.save.validate.SaveValidateFactory;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.meta.StringList;
import iih.ci.ord.s.external.obtain.bp.bl.GetArrearageCheckBP;
import iih.mm.itf.basematerialdto.d.BaseMaterialDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
/**
 * CI医嘱开立医疗单保存操作BP
 */
public class CiOrEmsSaveBP {

	/**
	 * CI医嘱开立医疗单保存操作
	 * 
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public  CiorderAggDO[] exec(CiEnContextDTO ctx, CiEmsDTO ems)  throws BizException{
		
		long tBeginTime = System.currentTimeMillis();
		//有效性判断
		if(!isValidate(ems))return null;
		
		OrdBizLogger.info(ctx, String.format("保存医嘱[%s]，有效性判断,耗时:%s(ms)", ems.getName(),System.currentTimeMillis()-tBeginTime));
		
		//默认值设置
		tBeginTime = System.currentTimeMillis();
		defaultValueSet(ems);
		OrdBizLogger.info(ctx, String.format("保存医嘱[%s]，有效性判断,耗时:%s(ms)", ems.getName(),System.currentTimeMillis()-tBeginTime));
		
		tBeginTime = System.currentTimeMillis();
		//判断是否有基数药
		IsBaseMaterial(ems);
		OrdBizLogger.info(ctx, String.format("保存医嘱[%s]，基数药判断,耗时:%s(ms)", ems.getName(),System.currentTimeMillis()-tBeginTime));
		
		//根据ems数据获得医嘱聚集DO及相关实体数据信息
		tBeginTime = System.currentTimeMillis();
		CiOrAggAndRelDatum oragginfo=createOrAggAndRelInfo8CiOrEms(ems);
		OrdBizLogger.info(ctx, String.format("保存医嘱[%s]，生成聚合结构,耗时:%s(ms)", ems.getName(),System.currentTimeMillis()-tBeginTime));
		//获得皮试医嘱及其相关实体数据信息
		ArrayList<CiOrAggAndRelDatum> skintestagginfos=null;

		skintestagginfos=getSkinTestOrInfos(oragginfo);  //将替换上述两行代码
		//重新处理下医嘱内容
		handleOrContent(oragginfo,ems);
		//聚集医嘱VO实体数据保存
		CiorderAggDO[] aggors=null;
		tBeginTime = System.currentTimeMillis();
		//如果存在医保，设置医保id_hp
		//CiOrdUtils.setIdHpValue(oragginfo,skintestagginfos);
		OrdBizLogger.info(ctx, String.format("保存医嘱[%s]，查询设置医保信息,耗时:%s(ms)", ems.getName(),System.currentTimeMillis()-tBeginTime));
		//放开多次多量后重新处理下总量和剂量
		handleSrvQuan(oragginfo,ems);
		tBeginTime = System.currentTimeMillis();
		aggors=saveAggDON(oragginfo,skintestagginfos,null,ems.getEmstype());  //将替换上述一行代码
		
		OrdBizLogger.info(ctx, String.format("保存医嘱[%s]，处理聚集结构并保存数据库,耗时:%s(ms)", ems.getName(),System.currentTimeMillis()-tBeginTime));
		return aggors;
		//暂时方案 toto
//		if(aggors != null){
//			if(aggors.length>1){
//				return aggors[1];
//			}
//			return aggors[0];
//		}else{
//			return  new CiorderAggDO();
//		}
		
	}
	
	/**
	 * CI医嘱开立医疗单保存操作
	 * 
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public  EmsRstDTO[] exec2(CiEnContextDTO ctx, CiEmsDTO ems)  throws BizException{
		
		long tBeginTime = System.currentTimeMillis();
		//有效性判断
		if(!isValidate(ems))return null;
		
		OrdBizLogger.info(ctx, String.format("保存医嘱[%s]，有效性判断,耗时:%s(ms)", ems.getName(),System.currentTimeMillis()-tBeginTime));
		
		//默认值设置
		tBeginTime = System.currentTimeMillis();
		defaultValueSet(ems);
		OrdBizLogger.info(ctx, String.format("保存医嘱[%s]，有效性判断,耗时:%s(ms)", ems.getName(),System.currentTimeMillis()-tBeginTime));
		
		tBeginTime = System.currentTimeMillis();
		//判断是否有基数药
		IsBaseMaterial(ems);
		OrdBizLogger.info(ctx, String.format("保存医嘱[%s]，基数药判断,耗时:%s(ms)", ems.getName(),System.currentTimeMillis()-tBeginTime));
		
		//根据ems数据获得医嘱聚集DO及相关实体数据信息
		tBeginTime = System.currentTimeMillis();
		CiOrAggAndRelDatum oragginfo=createOrAggAndRelInfo8CiOrEms(ems);
		OrdBizLogger.info(ctx, String.format("保存医嘱[%s]，生成聚合结构,耗时:%s(ms)", ems.getName(),System.currentTimeMillis()-tBeginTime));
		//获得皮试医嘱及其相关实体数据信息
		ArrayList<CiOrAggAndRelDatum> skintestagginfos=null;

		skintestagginfos=getSkinTestOrInfos(oragginfo);  //将替换上述两行代码
		//重新处理下医嘱内容
		handleOrContent(oragginfo,ems);
		//聚集医嘱VO实体数据保存
		CiorderAggDO[] aggors=null;
		tBeginTime = System.currentTimeMillis();
		//如果存在医保，设置医保id_hp
		//CiOrdUtils.setIdHpValue(oragginfo,skintestagginfos);
		OrdBizLogger.info(ctx, String.format("保存医嘱[%s]，查询设置医保信息,耗时:%s(ms)", ems.getName(),System.currentTimeMillis()-tBeginTime));
		//放开多次多量后重新处理下总量和剂量
		handleSrvQuan(oragginfo,ems);
		tBeginTime = System.currentTimeMillis();
		aggors=saveAggDON(oragginfo,skintestagginfos,null,ems.getEmstype());  //将替换上述一行代码
		
		OrdBizLogger.info(ctx, String.format("保存医嘱[%s]，处理聚集结构并保存数据库,耗时:%s(ms)", ems.getName(),System.currentTimeMillis()-tBeginTime));
		List<EmsRstDTO>rst=new ArrayList<>();
		for (CiorderAggDO ciorderAggDO : aggors) {
			EmsRstDTO r=new EmsRstDTO();
			FArrayList document=new FArrayList();
			document.add(ciorderAggDO.getParentDO());
			r.setDocument(document);
			Hashtable ht=oragginfo.getOrattachht();
			FMap2 extension=new FMap2();
			if(ht.containsKey("RelSrvMessageList")) {			
				StringList msg=(StringList)ht.get("RelSrvMessageList");
				extension.put("RelSrvMessageList", msg.toString());			
			}
			r.setExtension(extension);
			rst.add(r);
		}
		return rst.toArray(new EmsRstDTO[0]);
		//暂时方案 toto
//		if(aggors != null){
//			if(aggors.length>1){
//				return aggors[1];
//			}
//			return aggors[0];
//		}else{
//			return  new CiorderAggDO();
//		}
		
	}
	/**
	 * 处理医嘱相关信息中总量计算处理
	 * @param oragginfo
	 * @throws BizException 
	 */
	private void handleSrvQuan(CiOrAggAndRelDatum oragginfo,CiEmsDTO ems) throws BizException{
		CiorderAggDO aggorder = oragginfo.getOraggdo();
		CiOrderDO ordo = aggorder.getParentDO();
		OrdSrvDO[] ordsrvs = aggorder.getOrdSrvDO();
		CalQuantumBP bp = new CalQuantumBP();
		IFreqdefMDORService ifreqdefMDORService = CiOrdAppUtils.getFreqdefMDORService();
		FreqDefDO freqDef = ifreqdefMDORService.findById(ordo.getId_freq());
		if (freqDef == null) {
			throw new BizException("获取频次SD失败！");
		}
		
		if(!ordo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG) ){
			
			if(ordo.getFg_set().equals(FBoolean.TRUE)){
				OrdSrvDO mainsrv = getMainSrvInfo(ordo, ordsrvs);
				if(!CiOrdUtils.isEmpty(mainsrv)){
					for (OrdSrvDO ordSrvDO : ordsrvs) {
						//组合定价中包含物品，但是总量不用重新计算了,因为在组装数据时已经算过了
						if(!FBoolean.TRUE.equals(ordSrvDO.getFg_mm())){
							if (IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE.equals(freqDef.getFre_code())) {
							QuantumParamDTO quantum = new QuantumParamDTO(ems,ordSrvDO,true);
							ordSrvDO.setQuan_total_medu(bp.getQuantum(quantum));
							}else{
								ordSrvDO.setQuan_total_medu(null);
							}
							
						}
					}
//					if(CiOrdUtils.isSrvsetMemberCntPrimd(mainsrv.getId_primd())){
//						for (OrdSrvDO ordSrvDO : ordsrvs) {
////							if(ordSrvDO.getFg_set().equals(FBoolean.FALSE)){
////								ordSrvDO.setQuan_medu(ordo.getQuan_medu());
////							}
//							QuantumParamDTO quantum = new QuantumParamDTO(ems,ordSrvDO,true);
////							ordSrvDO.setQuan_total_medu(ordSrvDO.getQuan_total_medu().multiply(bp.getQuantum(quantum)));
//							ordSrvDO.setQuan_total_medu(bp.getQuantum(quantum));
//						}
//					}else if(CiOrdUtils.isSrvsetMemCntAdditionalPrimd(mainsrv.getId_primd())){
//						for (OrdSrvDO ordSrvDO : ordsrvs) {
////							if(ordSrvDO.getFg_set().equals(FBoolean.FALSE) && ordSrvDO.getEu_sourcemd() ==OrSrvSourceFromEnum.AGENTFROMPRIMD){
////								ordSrvDO.setQuan_medu(ordSrvDO.getQuan_medu().multiply(ordo.getQuan_medu()));
////							}
//							QuantumParamDTO quantum = new QuantumParamDTO(ems,ordSrvDO,true);
////							ordSrvDO.setQuan_total_medu(ordSrvDO.getQuan_total_medu().multiply(bp.getQuantum(quantum)));
//							ordSrvDO.setQuan_total_medu(bp.getQuantum(quantum));
//						}
//					}else if(CiOrdUtils.isSrvsetMemberSumPrimd(mainsrv.getId_primd())){
//						for (OrdSrvDO ordSrvDO : ordsrvs) {
//							QuantumParamDTO quantum = new QuantumParamDTO(ems,ordSrvDO,false);
//							ordSrvDO.setQuan_total_medu(bp.getQuantum(quantum));
//						}
//					}
				}
			}else{
				for (OrdSrvDO ordSrvDO : ordsrvs) {
					//组合定价中包含物品，但是总量不用重新计算了,因为在组装数据时已经算过了
					if(!FBoolean.TRUE.equals(ordSrvDO.getFg_mm())){
						if (IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE.equals(freqDef.getFre_code())) {
						QuantumParamDTO quantum = new QuantumParamDTO(ems,ordSrvDO,false);
							ordSrvDO.setQuan_total_medu(bp.getQuantum(quantum));
						}else{
							ordSrvDO.setQuan_total_medu(null);
						}
							
					}
				}
			}
		}
		
	}
	private OrdSrvDO getMainSrvInfo(CiOrderDO ordo,OrdSrvDO[] ordsrvs){
		for (OrdSrvDO ordSrvDO : ordsrvs) {
			if(ordo.getId_srv().equals(ordSrvDO.getId_srv())){
				return ordSrvDO;
			}
		}
		return null;
	}
	/**
	 * 处理医嘱内容
	 * @param oragginfo
	 * @param ems
	 * @throws BizException
	 */
	private void handleOrContent(CiOrAggAndRelDatum oragginfo,CiEmsDTO ems) throws BizException{
		CiorderAggDO aggorder = oragginfo.getOraggdo();
		Hashtable ht = oragginfo.getOrattachht();
		CiOrderDO order = aggorder.getParentDO();
		OrdSrvDO[] ordsrvs = aggorder.getOrdSrvDO();
		GetOrContentRelInfoBP2 bp = new GetOrContentRelInfoBP2();
		if(!CiOrdUtils.isEmpty(ht) && !CiOrdUtils.isEmpty(ht.get(OrdSrvMmDODesc.CLASS_FULLNAME))) {
			FMap mmMap = (FMap)ht.get(OrdSrvMmDODesc.CLASS_FULLNAME);
			CiOrIdentifcationInfo oridrelinfo = bp.exec(ems,order,ordsrvs,mmMap);
			order.setContent_or(oridrelinfo.getContent());
		}else{
			CiOrIdentifcationInfo oridrelinfo = bp.exec(ems,order,ordsrvs,null);
			order.setContent_or(oridrelinfo.getContent());
		}
		return ;
	}
	private CiorderAggDO[] delskintests=null;
	private ArrayList<String> skinorkeys=null;

	/**
	 * 有效性判断
	 * @param ems
	 * @return
	 * @throws BizException 
	 */
	private boolean isValidate(CiEmsDTO ems) throws BizException{
		if(ems==null)return false;
		BaseSaveValidateBP bp = SaveValidateFactory.getValidate(ems.getSd_srvtp(), ems.getCode_entp(), ems.getFg_pres_outp());
		EmsValidateRstDTO validateRst = bp.exec(ems);
		if(validateRst!=null && validateRst.getErrorList()!=null&&validateRst.getErrorList().size()>0){
			StringBuilder sb = new StringBuilder();
			for(Object obj : validateRst.getErrorList()){
				String errorInfo = (String)obj;
				sb.append(errorInfo);
			}
			throw new BizException(sb.toString());
		}
		//医嘱开立时，有效性校验主逻辑
		invalidateCheck(ems);
		
		return true;
	}
	
	/**
	 * 医疗单默认值设置处理逻辑
	 * @param ems
	 * @throws BizException
	 */
	private void defaultValueSet(CiEmsDTO ems) throws BizException{
		if(ems==null)return;
		
		CiEmsDefaultValueSetBP bp=new CiEmsDefaultValueSetBP();
		bp.exec(ems);
	}
	
	/**
	 * 创建医嘱聚集DO及其相关信息
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	private CiOrAggAndRelDatum createOrAggAndRelInfo8CiOrEms(CiEmsDTO ems) throws BizException{
		CiOrEms2OrAggAndRelInfoBP bp=new CiOrEms2OrAggAndRelInfoBP();
		return bp.exec(ems);
	}
	
	/**
	 * 医嘱保存
	 * @param new
	 * @throws BizException
	 */
	private CiorderAggDO[] saveAggDO(CiOrAggAndRelDatum oragginfo,ArrayList<CiOrAggAndRelDatum> skintestagginfos,CiorderAggDO[] delskintests,int iemstp) throws BizException{
		//医嘱保存
		CiorderAggDO aggdo=ciOrAndRelInfoSave(oragginfo,iemstp);
		
		//皮试医嘱相关保存逻辑处理
		CiorderAggDO[] aggskindos=null;
		if(skintestagginfos!=null && skintestagginfos.size()!=0){
			//参数设置
			aggskindos=new CiorderAggDO[skintestagginfos.size()];
			
			//遍历
			for(int i=0;i<skintestagginfos.size();i++){
				//临床医嘱皮试相关信息处理
				CiOrAggSkinTestInfoHandle(aggdo,skintestagginfos.get(i).getOraggdo());
				
				//皮试医嘱保存
				aggskindos[i]=ciOrAndRelInfoSave(skintestagginfos.get(i),-1);	
				
				//皮试结果预存
				ciOrSkinTestRsPreSave(aggskindos[i]);
				
			}
		}
		
		//关联的皮试医嘱删除逻辑
		delRelSkinTestAggDOs(delskintests);		
		//临床事件保存
		CiorderAggDO[] aggs=ciEventInfoSave(aggdo,aggskindos);
		
		return aggs;
	}
	
	/**
	 * 医嘱保存
	 * @param new
	 * @throws BizException
	 */
	private CiorderAggDO[] saveAggDON(CiOrAggAndRelDatum oragginfo,ArrayList<CiOrAggAndRelDatum> skintestagginfos,CiorderAggDO[] delskintests,Integer iemstp) throws BizException{
		
		//皮试医嘱相关保存逻辑处理
		CiorderAggDO[] aggskindos=null;
		if(!CiOrdUtils.isEmpty(skintestagginfos)){
			//参数设置
			aggskindos=new CiorderAggDO[skintestagginfos.size()];
			
			//遍历
			for(int i=0;i<skintestagginfos.size();i++){
				
				//皮试医嘱保存
				aggskindos[i]=ciOrAndRelInfoSave(skintestagginfos.get(i),-1);	
				
				//皮试结果预存  //2016-08-18  调整皮试结果保存逻辑  到ciOrAndRelInfoSave函数中
				//ciOrSkinTestRsPreSave(aggskindos[i]);//2016-08-18注释掉该行
				
			}
		}
		
		//临床医嘱皮试相关信息处理
		CiOrAggSkinTestInfoHandle(oragginfo,aggskindos);
		//清除错误信息
		oragginfo.getOraggdo().getParentDO().setError_level("A");
		oragginfo.getOraggdo().getParentDO().setError_des(null);
		//医嘱保存
		CiorderAggDO aggdo=ciOrAndRelInfoSave(oragginfo,iemstp);
		
		//关联的皮试医嘱删除逻辑
		delRelSkinTestAggDOs(delskintests);	
		//orSrv关联医保信息保存
		//ciOrSrvHpInfoSave(aggdo, oragginfo);
		//临床事件保存
		CiorderAggDO[] aggs=ciEventInfoSave(aggdo,aggskindos);
		
		return aggs;
	}
	/**
	 * 保存ci_or_srv_hp信息
	 * @param aggdo
	 * @param oragginfo
	 * @throws BizException 
	 */
	private void ciOrSrvHpInfoSave(CiorderAggDO aggdo,CiOrAggAndRelDatum oragginfo) throws BizException{
		Hashtable ht = oragginfo.getOrattachht();
		ArrayList<CiOrSrvHpDO> srvHpList = new ArrayList<CiOrSrvHpDO>();
		if(!CiOrdUtils.isEmpty(ht)){
			ArrayList<HashMap<String, CiOrSrvHpDO>> orSrvHpList = (ArrayList<HashMap<String, CiOrSrvHpDO>>) ht.get(ICiDictCodeConst.CI_OR_SRV_HP_KEY);
			if(!CiOrdUtils.isEmpty(orSrvHpList)){
				for (int i = 0; i < orSrvHpList.size(); i++) {
					for(int j = 0;j<aggdo.getOrdSrvDO().length;j++){
						CiOrSrvHpDO ciorsrvhpdo = orSrvHpList.get(i).get(aggdo.getOrdSrvDO()[j].getId_srv());
						if(!CiOrdUtils.isEmpty(ciorsrvhpdo)){
							if(!CiOrdUtils.isEmpty(aggdo.getOrdSrvDO()[j].getId_orsrv())){
								ciorsrvhpdo.setId_orsrv(aggdo.getOrdSrvDO()[j].getId_orsrv());
							}
						} 
					}
					HashMap<String,CiOrSrvHpDO> map = orSrvHpList.get(i);
					Iterator iter = map.entrySet().iterator();
					while (iter.hasNext()) {
						Map.Entry entry = (Map.Entry) iter.next();
						CiOrSrvHpDO val = (CiOrSrvHpDO) entry.getValue();
						if(!CiOrdUtils.isEmpty(val.getId_orsrv())) srvHpList.add(val);
					}
				}
				if(!CiOrdUtils.isEmpty(srvHpList)){
					ICiorsrvhpCudService iciorsrvhpcudservice = CiOrdAppUtils.getICiorsrvhpCudService();
					//iciorsrvhpcudservice.save(srvHpList.toArray(new CiOrSrvHpDO[srvHpList.size()]));
				}
			}
		}
		
		
	}
	/**
	 * 医嘱及相关实体信息保存
	 * @param oraggandrelinfo
	 * @throws BizException 
	 */
	private CiorderAggDO ciOrAndRelInfoSave(CiOrAggAndRelDatum oraggandrelinfo,Integer iemstp) throws BizException{
		CiOrAggAndRelInfoSaveBP bp=new CiOrAggAndRelInfoSaveBP();
		int status = DOStatus.NEW;//默认是新增
		try{
			status = oraggandrelinfo.getOraggdo().getParent().getStatus();//判断医嘱是不是新增
		}catch(Exception e){}
		CiorderAggDO aggdo= bp.exec(oraggandrelinfo,false, iemstp);
		if(CiOrdUtils.isSkinOrType(aggdo.getParentDO().getSd_srvtp())&&status==DOStatus.NEW){//2016-08-18  调整皮试保存逻辑    支持手工创建皮试医嘱的情况
			ciOrSkinTestRsPreSave(aggdo);//皮试结果预存
		}
		return aggdo;
	}
	
	/**
	 * 临床医嘱皮试相关信息处理
	 * @param aggorder
	 * @param aggskin
	 */
	private void CiOrAggSkinTestInfoHandle(CiOrAggAndRelDatum oragginfo,CiorderAggDO[] aggskindos){
		//有效性校验
		if(CiOrdUtils.isEmpty(oragginfo) || CiOrdUtils.isEmpty(oragginfo.getOraggdo()) || CiOrdUtils.isEmpty(aggskindos))return;
		
		//参数设置
		CiOrderDO skinordo=null;
		OrdSrvDO[] orsrvdos=oragginfo.getOraggdo().getOrdSrvDO();
		
		//遍历
		for(int i=0;i<aggskindos.length;i++){
			skinordo=aggskindos[i].getParentDO();
			ordSrvRelSkinInfoHandle(orsrvdos,skinordo.getId_or(),i);
		}
	}
	
	/**
	 * 医嘱项目关联的皮试数据信息处理逻辑
	 */
	private void ordSrvRelSkinInfoHandle(OrdSrvDO[] orsrvdos,String id_or_skin,int index){
		//获得对应服务id
		String id_srv=getIdSrv(index);
		
		//遍历
		for(int i=0;i<orsrvdos.length;i++){
			if(id_srv.equals(orsrvdos[i].getId_srv())){
				orSrvSkinRelFldHandle(orsrvdos[i],id_or_skin);
				break;
			}
		}
		
	}
	
	/**
	 * 医嘱项目皮试关联字段数据信息处理
	 * @param orsrvdo
	 * @param id_orskin
	 */
	private void orSrvSkinRelFldHandle(OrdSrvDO orsrvdo,String id_orskin){
		orsrvdo.setFg_skintest(FBoolean.TRUE);
		orsrvdo.setSd_reltp(ICiDictCodeConst.SD_RELTYPE_SKINTEST);
		orsrvdo.setId_reltp(ICiDictCodeConst.SD_RELTYPE_ID_SKINTEST);
		orsrvdo.setId_or_rel(id_orskin);			
	}
	
	/**
	 * 获得对应服务ID
	 * @param index
	 * @return
	 */
	private String getIdSrv(int index){
		String id_srv_skin=skinorkeys.get(index);
		String[] sTs=id_srv_skin.split(CiOrdUtils.COMMA_STR);
		return sTs[0];
	}
	
	/**
	 * 临床医嘱皮试相关信息处理
	 * @param aggorder
	 * @param aggskin
	 */
	private void CiOrAggSkinTestInfoHandle(CiorderAggDO aggorder,CiorderAggDO aggskin){
		if(aggskin==null || aggorder==null)return;
		CiOrderDO skindo=aggskin.getParentDO();
		CiOrderDO do1=aggorder.getParentDO();
		skindo.setFg_skintest(FBoolean.TRUE);
		skindo.setSd_reltp(ICiDictCodeConst.SD_RELTYPE_SKINTEST);
		skindo.setId_reltp(ICiDictCodeConst.SD_RELTYPE_ID_SKINTEST);
		//skindo.setId_or_rel(do1.getId_or());
	}
	
	/**
	 * 获得皮试医嘱及相关附加数据信息
	 * @param ems
	 * @param oragginfo
	 * @return
	 * @throws BizException
	 */
	private ArrayList<CiOrAggAndRelDatum> getSkinTestOrInfos(CiEmsDTO ems,CiOrAggAndRelDatum oragginfo) throws BizException{
		//获得皮试物品对应的服务
		//MmRelSkinTestSrvDO[] id_srvs=CiOrdUtils.getCiOrSkinTestSrvs(skintestmmdos);
		MeterialDO[] id_srvs=CiOrdUtils.getCiOrSkinTestSrvsN(skintestmmdos);
		
		//有效性判断
		if(CiOrdUtils.isEmpty(id_srvs))return null;
		
		//参数设置
		String id_srv=id_srvs[0].getId_srvskin();
		CiOrAggAndRelDatum datum=null;
		ArrayList<CiOrAggAndRelDatum> list=new ArrayList<CiOrAggAndRelDatum>();
		CiorderAggDO[] orrelstaggdos=getOrRelSkinTestOrAggs(oragginfo.getOraggdo());
		ArrayList<Integer> usedstaggindexs=new ArrayList<Integer>();
		Integer index=-1;
		
		//遍历
		for(int i=0;i<id_srvs.length;i++){
			id_srv=id_srvs[i].getId_srvskin();
			
			//修改逻辑的出来逻辑
			index=CiOrdUtils.getMatchedAggDOIndex4SkinTest(orrelstaggdos, id_srv);
			if(index!=null && index>=0){usedstaggindexs.add(index);continue;}
			
			//生成皮试医嘱数据
			datum=getSkinTestOrInfo(ems,id_srv);
			
			//返回值的判断逻辑
			if(datum==null)continue;
			list.add(datum);
		}
		
		//获得删除的皮试医嘱
		delskintests=getDelSkinTestAggOr(orrelstaggdos,usedstaggindexs);
		
		//返回值处理
		if(list!=null && list.size()!=0)return list;
		return null;
	}
	

	
	/**
	 * 获得皮试医嘱及相关附加数据信息
	 * @param ems
	 * @param oragginfo
	 * @return
	 * @throws BizException
	 */
	private ArrayList<CiOrAggAndRelDatum> getSkinTestOrInfos(CiOrAggAndRelDatum oragginfo) throws BizException{
		//新增皮试自动生成启动参数逻辑控制  2016-11-25 
		if(!CiOrParamUtils.IsAutoGenSkinTestOrEnable(CiOrParamUtils.getOrgID(oragginfo)))return null;
		
		//有效性判断
		skinorkeys=new ArrayList<String>();
		if(CiOrdUtils.isEmpty(oragginfo))return null;

		//0194238: 参数BLCG0040设置校验
		ordPriValidate(oragginfo);
		//获得医嘱关联皮试医嘱数据信息
		Hashtable ht=oragginfo.getOrattachht();
		if(CiOrdUtils.isEmpty(ht))return null;
		FMap map=CiOrAttachInfoUtils.getRelSkinOrDOMap(ht);
		
		//参数定义
		ArrayList<CiOrAggAndRelDatum> list=new ArrayList<CiOrAggAndRelDatum>();
		CiOrAggAndRelDatum reldatum;
		
		if(map!=null)
		{
			//遍历
			for(String key: map.keySet()){
				reldatum=(CiOrAggAndRelDatum)map.get(key);
				if(CiOrdUtils.isEmpty(reldatum))continue;
				list.add(reldatum);
				skinorkeys.add(key);
			}
		}
		//返回值处理
		if(list!=null && list.size()!=0)return list;
		return null;
	}
	
	/**
	 * 获得删除的皮试医嘱
	 * @param orrelstaggdos
	 * @param usedstaggindexs
	 * @return
	 */
	private CiorderAggDO[] getDelSkinTestAggOr(CiorderAggDO[] orrelstaggdos,ArrayList<Integer> usedstaggindexs){
		if(CiOrdUtils.isEmpty(orrelstaggdos))return null;
		if(CiOrdUtils.isEmpty(usedstaggindexs))return orrelstaggdos;
		int iL=orrelstaggdos.length;
		int iN=usedstaggindexs.size();
		CiorderAggDO[] rtns=new CiorderAggDO[iL-iN];
		String matchstr=CiOrdUtils.COMMA_STR+CiOrdUtils.aryToString(usedstaggindexs)+CiOrdUtils.COMMA_STR;
		int iM=0;
		for(int i=0;i<iL;i++){
			if(matchstr.indexOf(CiOrdUtils.COMMA_STR+i+CiOrdUtils.COMMA_STR)>=0){}
			else{rtns[iM]=orrelstaggdos[i];}
		}
				
		return rtns;
	}
	
	/**
	 * 获得皮试医嘱及相关附加数据信息
	 * @param ems
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private CiOrAggAndRelDatum getSkinTestOrInfo(CiEmsDTO ems,String id_srv) throws BizException{
		//获得皮试医疗单数据
		CiOrSkinTestOrBuildBP bp=new CiOrSkinTestOrBuildBP();
		CiEmsDTO skinems=bp.exec(id_srv,ems);
		
		//生成皮试医嘱及关联信息数据
		CiOrEms2OrAggAndRelInfoBP bp1=new CiOrEms2OrAggAndRelInfoBP();
		return bp1.exec(skinems);
	}
	private MeterialDO[] skintestmmdos=null;  //需皮试物品列表
	
	/**
	 * 是否需皮试医嘱
	 * @param ems
	 * @return
	 * @throws BizException 
	 */
	private boolean isKinTest(CiEmsDTO ems) throws BizException{
		skintestmmdos=CiOrdUtils.getEmsNeedSkinTestMm(ems);
		return CiOrdUtils.isSkinTestMm(ems,skintestmmdos);
	}
	
	/**
	 * 
	 * @param ems
	 * @throws BizException
	 */
	private void getSkinTestInfo(CiEmsDTO ems) throws BizException{
		skintestmmdos=CiOrdUtils.getEmsNeedSkinTestMm(ems);
		
	}
	
	/**
	 * 临床事件保存
	 * @param aggdos
	 * @return
	 * @throws BizException
	 */
	private CiorderAggDO[] ciEventInfoSave(CiorderAggDO aggdo,CiorderAggDO[] aggskindos) throws BizException{
		//有效性校验
		
		//if(aggdo==null || aggskindos==null || aggskindos.length==0)return null; 
		 // 李政  修改 压力测试有问题
		if(aggdo==null)return null; 
		// lizheng  修改
		Object[] obj = CiOrdUtils.mergeObjAry(getCiorderAggs(aggdo),aggskindos);
		if(obj ==null) throw new BizException("医嘱集合为空");
		CiorderAggDO[] aggdos = new CiorderAggDO[obj.length];
		for(int i =0;i<obj.length;i++){
			aggdos[i] = (CiorderAggDO)obj[i];
		}
		 // start  lizheng  修改上面  下面 报异常    java.lang.ClassCastException
		//CiorderAggDO[] aggdos=(CiorderAggDO[])CiOrdUtils.mergeObjAry(getCiorderAggs(aggdo),aggskindos);
		// end   lizheng   
		//医嘱事件创建保存 时机应该选择为 签署阶段
		//CiOrEventsSaveBP bp=new CiOrEventsSaveBP();
		//bp.exec(aggdos.getParentDO());
		
		return aggdos;
	}
	
	/**
	 * 获得数组
	 * @param aggdo
	 * @return
	 */
	private CiorderAggDO[] getCiorderAggs(CiorderAggDO aggdo){
		CiorderAggDO[] aggors=null;
		if(aggdo!=null)aggors=new CiorderAggDO[]{aggdo};
		return aggors;
	}
	
	/**
	 * 皮试医嘱结果预存
	 * @param aggskindo
	 * @throws BizException 
	 */
	private void ciOrSkinTestRsPreSave(CiorderAggDO aggskindo) throws BizException{
		CiOrSkinTestRsPreSaveBP bp=new CiOrSkinTestRsPreSaveBP();
		bp.exec(aggskindo);
	}
	
	/**
	 * 获得医嘱关联的皮试医嘱集合信息
	 * @param oragg
	 * @return
	 * @throws BizException
	 */
	private CiorderAggDO[] getOrRelSkinTestOrAggs(CiorderAggDO oragg) throws BizException{
		GetCiOrRelSkinTestOrAggsBP bp=new GetCiOrRelSkinTestOrAggsBP();
		return bp.exec(oragg);
	}
	
	/**
	 * 删除关联的皮试医嘱及关联信息
	 * @param delskintests
	 * @throws BizException
	 */
	private void delRelSkinTestAggDOs(CiorderAggDO[] delskintests) throws BizException{
		if(delskintests==null || delskintests.length==0)return;
		for(int i=0;i<delskintests.length;i++){
			delAggDO(delskintests[i]);
		}
	}
	
	/**
	 * 删除医嘱及相关数据
	 * @param aggdo
	 * @throws BizException
	 */
	private void delAggDO(CiorderAggDO aggdo) throws BizException{
		CiOrDeleteBP bp=new CiOrDeleteBP();
		bp.exec(aggdo.getParentDO().getId_or());
	}
	
	/**
	 * 有效性校验
	 * @param ems
	 * @throws BizException 
	 */
	private void invalidateCheck(CiEmsDTO ems) throws BizException{
		//医嘱开立时，医嘱有效性校验操作BP
		CiOrOpenEmsInvalidateBP bp = new CiOrOpenEmsInvalidateBP();
		bp.exec(ems);
	}
	
	/**
	 * 基数药的判断
	 * @param ems
	 * @throws BizException
	 */
	private void IsBaseMaterial(CiEmsDTO ems)throws BizException{
		 
		FArrayList materialList =  new <BaseMaterialDTO>FArrayList();
		FArrayList list = ems.getEmssrvs();
		if(list  != null){
			CiEmsSrvDTO srvDto1 = (CiEmsSrvDTO)list.get(0);
			if(!CiOrdUtils.isEmpty(srvDto1.getFg_outp())&&srvDto1.getFg_outp().isValue()) return;
			for(int i =0;i<list.size();i++){
				CiEmsSrvDTO srvDto = (CiEmsSrvDTO)list.get(i);
				 if(srvDto.getId_mm() != null && !"".equals(srvDto.getId_mm())){
					 BaseMaterialDTO materialDTO = new BaseMaterialDTO();
					 materialDTO.setId_srv(srvDto.getId_srv());
					 materialDTO.setId_mm(srvDto.getId_mm());
					 materialDTO.setId_dep(srvDto.getId_dep());
					 if(CiOrdUtils.isEmpty(srvDto.getId_dep())){
						 CiOrEndDtHandleBP bp = new CiOrEndDtHandleBP();
						 FDateTime[] fdate= bp.exec(ems);
						 ExeWhDeptDTO exewhdto = CiOrdUtils.getMpDeptID(ems,i,fdate[0]);  //待打开
						 materialDTO.setId_dep(exewhdto.getId_dep_mp());
						 if(CiOrdUtils.isEmpty(srvDto.getId_dep())){
							 continue;
						 }
					 }
					 materialList.add(materialDTO);
				 }
			}
		}
		if(materialList != null && materialList.size() >0){
			BaseMaterialDTO[]  baseMaterials = new BaseMaterialDTO[materialList.size()];
	         for(int j =0;j<materialList.size();j++){
	        	 baseMaterials[j] = (BaseMaterialDTO)materialList.get(j);
	         }
	         BaseMaterialDTO[] baseMMDTOS = CiOrdAppUtils.getIMaterialBaseInfoService().isBaseMaterial(baseMaterials);
	         Map map =  getMap(baseMMDTOS);
		  if(map !=null){
				if(list  != null){
					String key = "";
					for(int i =0;i<list.size();i++){
						CiEmsSrvDTO srvDto = (CiEmsSrvDTO)list.get(i);
						
						 if(srvDto.getId_mm() != null && !"".equals(srvDto.getId_mm())){
							 key = srvDto.getId_dep()+srvDto.getId_srv()+srvDto.getId_mm();
							 BaseMaterialDTO material = (BaseMaterialDTO)map.get(key);
							 if(material != null){
								 srvDto.setFg_base(material.getFg_base());
							 }
						 }
					}
				}
		   }
		}
		
	}
	
    private Map getMap(BaseMaterialDTO[] baseMMDTOS){
    	Map  map = new <BaseMaterialDTO>HashMap();
    	if(baseMMDTOS != null){
    		String key ="";
    		for(BaseMaterialDTO  dto:baseMMDTOS){
    			key = dto.getId_dep()+dto.getId_srv()+dto.getId_mm();
    			map.put(key, dto);
    		}
    	}
    	return map;
    }

	/**
	 * @throws BizRuntimeException 
	 * @oragginfo 需要计费的医嘱，费用不能为零
	 * @param ems
	 */
	private void ordPriValidate(CiOrAggAndRelDatum oragginfo) throws BizException {
		OrdSrvDO[] ordSrvDOs = oragginfo.getOraggdo().getOrdSrvDO();
		if(ordSrvDOs != null && ordSrvDOs.length > 0) {
			for (OrdSrvDO ordSrvDO : ordSrvDOs) {
				if(FBoolean.FALSE.equals(BlParams.BLCG0040())){
					if(FBoolean.TRUE.equals(ordSrvDO.getFg_bl()) &&
							(ordSrvDO.getPri().equals(FDouble.ZERO_DBL))) {
						String msg = "付费服务：【%s】0元医嘱不可开立。";
						msg = String.format(msg, ordSrvDO.getName());
						throw new BizRuntimeException(msg);
					}
				}else{
					if(FBoolean.TRUE.equals(ordSrvDO.getFg_bl()) &&
							(ordSrvDO.getEu_blmd() != null && 1 == ordSrvDO.getEu_blmd()) &&
							(ordSrvDO.getPri().equals(FDouble.ZERO_DBL))) {
						String msg = "付费服务：【%s】0元医嘱不可开立。";
						msg = String.format(msg, ordSrvDO.getName());
						throw new BizRuntimeException(msg);
					}
				}
			}
		}
	}
}
