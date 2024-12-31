package iih.ci.diag.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.cidiag.i.ICidiagCudService;
import iih.ci.diag.cidiag.i.ICidiagRService;
import iih.ci.diag.s.CiDiUtils;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.external.obtain.ICiOrdEnRService;
import iih.en.pv.entdi.d.EntDiDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 急诊抢救取本次抢救中前一次就诊的当前诊断保存
 * @author Lxy
 *
 */
public class SaveLastDiagInThisRescueBP {
	public CidiagAggDO[] exec(String id_en, CiEnContextDTO ctx) throws BizException{
		//查询上一次就诊的诊断id
		ICiOrdEnRService enService=(ICiOrdEnRService)ServiceFinder.find(ICiOrdEnRService.class);
		String[] id_dis=enService.getLastEnDiIds(id_en);
		if(id_dis==null || id_dis.length<1)return null;
		//查询具体诊断信息
		ICidiagRService diRService=(ICidiagRService)ServiceFinder.find(ICidiagRService.class);
		CidiagAggDO[] ciDiArray=diRService.findByBIds(id_dis, FBoolean.FALSE);
		if(ciDiArray==null || ciDiArray.length<1)return null;
		//复制诊断
		List<CidiagAggDO> aggdolist=new ArrayList<CidiagAggDO>();
		for(CidiagAggDO lastAggDo:ciDiArray){
			TimeService ts=(TimeService)ServiceFinder.find(TimeService.class.getName());
			CidiagAggDO aggDo=new CidiagAggDO();
			aggDo.deSerializeJson(lastAggDo.serializeJson());
			aggDo.getParentDO().setId_di(null);
			aggDo.getParentDO().setStatus(DOStatus.NEW);
			aggDo.getParentDO().setId_en(id_en);
			aggDo.getParentDO().setDt_di(ts.getUFDateTime());
			aggDo.getParentDO().setDt_sign(ts.getUFDateTime());
			aggDo.getParentDO().setId_dep(Context.get().getDeptId());
			aggDo.getParentDO().setId_dep_sign(Context.get().getDeptId());
			aggDo.getParentDO().setId_emp_sign(Context.get().getStuffId());
			aggDo.getParentDO().setId_emp_create(Context.get().getStuffId());
			aggDo.getParentDO().setId_dep_create(Context.get().getDeptId());
			aggDo.getParentDO().setDt_create(ts.getUFDateTime());
			aggDo.getParentDO().setSv(ts.getUFDateTime());
			for(CiDiagItemDO itemDo:aggDo.getCiDiagItemDO()){
				itemDo.setId_di(null);
				itemDo.setId_diitm(null);
				itemDo.setStatus(DOStatus.NEW);
				itemDo.setSv(ts.getUFDateTime());
			}	
			aggdolist.add(aggDo);
		}
		if(aggdolist.size()<1)return null;
		ICidiagCudService diCudService=(ICidiagCudService)ServiceFinder.find(ICidiagCudService.class);
		CidiagAggDO[] rtnDis= diCudService.save(aggdolist.toArray(new CidiagAggDO[aggdolist.size()]));
		if(rtnDis==null || rtnDis.length<1)return null;
		//保存就诊诊断
		saveEntDiDO(rtnDis);
		//发送集成平台
		SaveCiDiDtoBP saveCiDiDtoBP=new SaveCiDiDtoBP();
		saveCiDiDtoBP.IEDiagFireEvent(rtnDis[0], ctx);
		return rtnDis;
	}

	/**
	 * 保存就诊诊断
	 * @param id_en
	 * @return
	 * @throws BizException
	 */

	private  void saveEntDiDO(CidiagAggDO[] aggs)throws BizException{
		List<EntDiDO> entdis=new ArrayList<EntDiDO>();
		if(aggs != null){
			boolean Fg_maj = false;
			for(CidiagAggDO agg:aggs){
				int i = 0;
				if (agg.getCiDiagItemDO() != null && agg.getCiDiagItemDO().length > 0) {
					for (CiDiagItemDO item : agg.getCiDiagItemDO()) {
						EntDiDO entdi = new EntDiDO();
						entdi.setId_org(agg.getParentDO().getId_org());
						entdi.setId_grp(agg.getParentDO().getId_grp());
						entdi.setId_ent(agg.getParentDO().getId_en());
						entdi.setId_didef_dis(item.getId_didef());
						entdi.setName_didef_dis(item.getId_didef_name());
						entdi.setSupplement(item.getSupplement());
						entdi.setId_ditp(agg.getParentDO().getId_ditp());
						entdi.setSd_ditp(agg.getParentDO().getSd_ditp());
						entdi.setId_didef_syn(item.getId_didef_syn());
						entdi.setName_didef_syn(item.getDidef_syn_name());
						entdi.setId_dep(Context.get().getDeptId());
						entdi.setName_bddi(item.getId_didef_name());
						entdi.setDt_diag(agg.getParentDO().getDt_di());
						entdi.setId_diitm(item.getId_diitm());
						entdi.setId_emp_phy(agg.getParentDO().getId_emp_sign());
						entdi.setSd_cdsystp(item.getSd_disys());
						entdi.setId_cdsystp(item.getId_disys());
						entdi.setFg_chronic(item.getFg_chronic());
						entdi.setFg_special(item.getFg_special());
						entdi.setFg_ur(item.getFg_ur());
						entdi.setCode_didef_dis(item.getId_didef_code());
						entdi.setSortno(i);
						entdi.setId_parent(item.getId_parent());
						entdi.setInnercode(item.getInnercode());
						entdi.setFg_self(item.getFg_self());
						entdi.setId_di(item.getId_di());
						//entdi.setDes(dto.getSupply());
						//只有一个主诊断
						if (item.getFg_majdi().booleanValue() && !Fg_maj) {
							entdi.setFg_maj(item.getFg_majdi());
							Fg_maj = true;
						} else {
							entdi.setFg_maj(item.getFg_majdi());
						}

						//entdi.setFg_flupci(dto.getFg_flupci());
						//item.setFg_infedi(entdi.get);
						entdi.setFg_suspdi(item.getFg_suspdi());
						//entdi.setFg_sym(dto.getFg_sym());
						//entdi.setDes_di(agg.getParentDO().getDes_di());
						entdi.setId_infectiontp(item.getId_infectiontp());
						entdi.setSd_infectiontp(item.getSd_infectiontp());
//						entdi.setEu_hpbeyond(item.getEu_hpbeyond());// 0 医保内诊断 ，1 医保外诊断，9 非医保诊断 就诊临床诊断表暂无此字段
//						entdi.setCode_didef_syn(item.getId_didef_syn_code());// 证候诊断编码 就诊临床诊断表暂无此字段
						entdi.setStatus(DOStatus.NEW);
						entdis.add(entdi);
						i++;
					}
				}
			}
		}
		if(entdis.size()>0){
			CiDiUtils.getIEntdiCudService().save(entdis.toArray(new EntDiDO[entdis.size()]));
		}
	}
}
