package iih.bl.st.ip.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bl.hp.dto.d.IpBillItmUploadHpDTO;
import iih.bl.hp.hpblllitm.d.BlHpCgItmIpDo;
import iih.bl.hp.hpblllitm.i.IHpblllitmCudService;
import iih.bl.hp.hpblllitm.i.IHpblllitmRService;
import iih.bl.params.BlParams;
import iih.bl.st.ep.IpStEP;
import iih.en.pv.inpatient.d.NewbornDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.kernel.exception.DbException;

/**医保前置流程，暂不支持中途结算，太复杂了
 * @author xy.zhou
 */
public class UpdateHpCgBackFlagBp {
	public FBoolean exec(String strIdEnt,IpBillItmUploadHpDTO[] list, FBoolean isUploaded,FBoolean isFrontAfter) throws BizException
	{
		//业务说明，该流程只处理医保前置流程，包括出院结算、中途结算业务
		//中途结算：因为更新记账数据
		if(strIdEnt==null){
			throw new BizException("就诊号不能为null!");
		}
		if(isUploaded.booleanValue()){
			//正向操作
			updateCgFlagForword(list,strIdEnt,isFrontAfter);
		}else{
			//取消记账的医保上传标志
			updateCgFlagBack(strIdEnt,list);
		}
		return FBoolean.TRUE;
	}
	/**
	 * 根据结算主键撤销明细
	 * @param strIdEnt
	 * @param strIdStIp
	 * @param list
	 * @param isUploaded
	 * @param isFrontAfter
	 * @return
	 * @throws BizException 
	 */
	public FBoolean exec(String strIdEnt, String strIdStIp, IpBillItmUploadHpDTO[] list) throws BizException {
		if(strIdEnt==null){
			throw new BizException("就诊号不能为null!");
		}
		//根据结算主键和就诊主键撤销
		updateCgBackByIdStIp(strIdEnt,strIdStIp,list);
		return FBoolean.TRUE;
	}
	
	/**
	 * 明细上传
	 * @param list
	 * @throws BizException
	 */
	private void updateCgFlagForword(IpBillItmUploadHpDTO[] list,String strIdEnt,FBoolean isFrontAfter) throws BizException
	{
		Map<String, BlHpCgItmIpDo> map=new HashMap<>();
		if (!isFrontAfter.booleanValue()){
			 map= setBlHpCgItmIpDoMap(strIdEnt);
		}
		IHpblllitmCudService iCudService = ServiceFinder.find(IHpblllitmCudService.class);
		PersistMgr persist = null;
		PersistSession session = null;
		List<BlHpCgItmIpDo> saveList = new ArrayList<BlHpCgItmIpDo>();//ly 2018/11/24
		try {				
			persist = (PersistMgr) PersistMgr.getInstance();
			session = persist.getPersistSession();
			if(ArrayUtils.isEmpty(list)){
				throw new BizException("要更新的记账明细数量不能为0");
			}
			for (IpBillItmUploadHpDTO bill : list) {
				if (!isFrontAfter.booleanValue()) {
					BlHpCgItmIpDo hpCgItmIpDo = map.get(bill.getId_cgip());				
					//如果存在执行更新，不存在插入
					if (hpCgItmIpDo!=null) {
						
						hpCgItmIpDo.setId_ent(strIdEnt);
						hpCgItmIpDo.setId_cgip(bill.getId_cgip());
						hpCgItmIpDo.setAmt(bill.getAmt_ratio());
						hpCgItmIpDo.setAmt_payzl(bill.getAmt_pat());
						hpCgItmIpDo.setAmt_payzf(bill.getAmt_payzf());
						hpCgItmIpDo.setAmt_cxj_payzf(bill.getAmt_cxj_payzf());
						hpCgItmIpDo.setAmt_czl_payzf(bill.getAmt_czl_payzf());
						hpCgItmIpDo.setCode_ca(bill.getCode_ca());
						hpCgItmIpDo.setSd_hpsrvtp(bill.getName_chargegrade());
						hpCgItmIpDo.setFg_selfpay(bill.getFg_selfpay());
						hpCgItmIpDo.setRate_payzl(bill.getRate_payzl());
						hpCgItmIpDo.setLimited_pri(bill.getLimited_pri());
						hpCgItmIpDo.setHp_srvcode(bill.getHp_srvcode());
						//医师无处方权自费
						hpCgItmIpDo.setPresauth_self(bill.getPresauth_self());
						hpCgItmIpDo.setId_hpblllitm(hpCgItmIpDo.getId_hpblllitm());
						//自费原因备注
						hpCgItmIpDo.setDes(bill.getNote());
						hpCgItmIpDo.setStatus(DOStatus.UPDATED);
						saveList.add(hpCgItmIpDo);
						//iCudService.save(new BlHpCgItmIpDo[]{hpCgItmIpDo});
					}else {
						BlHpCgItmIpDo newHpCgIpDo = new BlHpCgItmIpDo();
						newHpCgIpDo.setId_ent(strIdEnt);
						newHpCgIpDo.setId_cgip(bill.getId_cgip());
						newHpCgIpDo.setAmt(bill.getAmt_ratio());
						newHpCgIpDo.setAmt_payzl(bill.getAmt_pat());
						newHpCgIpDo.setAmt_payzf(bill.getAmt_payzf());
						newHpCgIpDo.setAmt_cxj_payzf(bill.getAmt_cxj_payzf());
						newHpCgIpDo.setAmt_czl_payzf(bill.getAmt_czl_payzf());
						newHpCgIpDo.setCode_ca(bill.getCode_ca());
						newHpCgIpDo.setSd_hpsrvtp(bill.getName_chargegrade());
						newHpCgIpDo.setFg_selfpay(bill.getFg_selfpay());
						newHpCgIpDo.setRate_payzl(bill.getRate_payzl());
						newHpCgIpDo.setLimited_pri(bill.getLimited_pri());
						newHpCgIpDo.setHp_srvcode(bill.getHp_srvcode());
						newHpCgIpDo.setId_hpblllitm(null);
						//医师无处方权自费
						newHpCgIpDo.setPresauth_self(bill.getPresauth_self());
						newHpCgIpDo.setDes(bill.getNote());
						newHpCgIpDo.setStatus(DOStatus.NEW);
						saveList.add(newHpCgIpDo);
						//iCudService.save(new BlHpCgItmIpDo[]{newHpCgIpDo});
					}
				}
				StringBuilder sqlb = new StringBuilder();
				FDouble amt_hp=bill.getAmt_hp() ;
				FDouble amt_pat=bill.getAmt_pat();
				sqlb.append("update bl_cg_ip set fg_hp = 'Y' ");
//				if(amt_hp!=null&&amt_pat!=null){
//					sqlb.append(" ,amt_hp = ").append(amt_hp).append(", ");
//					sqlb.append(" amt_pat = ").append(amt_pat).append(" ");
//				}
				if(amt_hp!=null){
					sqlb.append(" ,amt_hp = ").append(amt_hp);	
				}
				if(amt_pat!=null){
					sqlb.append(" ,amt_pat = ").append(amt_pat);
				}
				if (bill.getId_hp()!=null) {
					sqlb.append(" , id_hp = '").append(bill.getId_hp()).append("' ");
				}
				sqlb.append("where id_cgip = ").append("'"+bill.getId_cgip()+"';");
				session.addBatch(sqlb.toString());
			}
			iCudService.save(saveList.toArray(new BlHpCgItmIpDo[0]));
			session.execBatch();
		}catch (DbException e) {
			throw new BizException("更新记账数据的医保状态失败，失败原因为："+e.getMessage());
		} finally {
			if (session != null)
				session.closeAll();

			if (persist != null)
				persist.release();
		}
	}
	/**
	 * 明细撤销
	 * @param strIdEnt
	 * @throws BizException
	 */
	private void updateCgFlagBack(String strIdEnt,IpBillItmUploadHpDTO[] list) throws BizException
	{
		PersistMgr persist = null;
		PersistSession session = null;
		try {				
			persist = (PersistMgr) PersistMgr.getInstance();
			session = persist.getPersistSession();			
			if(!ArrayUtils.isEmpty(list)) {
				for(IpBillItmUploadHpDTO itm : list) {
					StringBuilder sqlb = new StringBuilder();
					sqlb.append("update bl_cg_ip set fg_hp = 'N' ");
					sqlb.append(" ,amt_hp = ").append(0).append(", ");
					sqlb.append(" id_hp ='',");
					sqlb.append(" amt_pat = ").append(0).append(" ");
					sqlb.append(" where  ( id_cgip = '").append(itm.getId_cgip()).append("' or id_par = '").append(itm.getId_cgip()).append("' )");
					session.addBatch(sqlb.toString());
				}
			} else {
				StringBuilder sqlb = new StringBuilder();
				sqlb.append("update bl_cg_ip set fg_hp = 'N' ");
				sqlb.append(" ,amt_hp = ").append(0).append(", ");
				sqlb.append(" id_hp ='',");
				sqlb.append(" amt_pat = ").append(0).append(" ");
				sqlb.append(" where id_ent='").append(strIdEnt).append("'");
				session.addBatch(sqlb.toString());
			}
			session.execBatch();
		}catch (DbException e) {
			throw new BizException("更新记账数据的医保状态失败，失败原因为："+e.getMessage());
		} finally {
			if (session != null)
				session.closeAll();

			if (persist != null)
				persist.release();
		}
	}
	
	/**
	 * 明细撤销
	 * @param strIdEnt
	 * @throws BizException
	 */
	private void updateCgBackByIdStIp(String strIdEnt,String strIdStIp,IpBillItmUploadHpDTO[] list) throws BizException
	{
		PersistMgr persist = null;
		PersistSession session = null;
		try {				
			persist = (PersistMgr) PersistMgr.getInstance();
			session = persist.getPersistSession();			
			if(!ArrayUtils.isEmpty(list)) {
				for(IpBillItmUploadHpDTO itm : list) {
					StringBuilder sqlb = new StringBuilder();
					sqlb.append("update bl_cg_ip set fg_hp = 'N' ");
					sqlb.append(" ,amt_hp = ").append(0).append(", ");
					sqlb.append(" id_hp ='',");
					sqlb.append(" amt_pat = ").append(0).append(" ");
					sqlb.append(" where  ( id_cgip = '").append(itm.getId_cgip()).append("' or id_par = '").append(itm.getId_cgip()).append("' )");
					session.addBatch(sqlb.toString());
				}
			} else {
				StringBuilder sqlb = new StringBuilder();
				sqlb.append("update bl_cg_ip set fg_hp = 'N' ");
				sqlb.append(" ,amt_hp = ").append(0).append(", ");
				sqlb.append(" id_hp ='',");
				sqlb.append(" amt_pat = ").append(0).append(" ");
				String[] idEntBbs = this.getBbIdEnts(strIdEnt);
				if(idEntBbs != null && idEntBbs.length > 0){
					sqlb.append(" where ( id_ent='").append(strIdEnt).append("' or id_ent in (")
					.append(SqlUtils.arrayToStr(idEntBbs)).append(") )");

				}else{
					sqlb.append(" where id_ent='").append(strIdEnt).append("'");
					
				}
				if(StringUtils.isNotBlank(strIdStIp))
					sqlb.append(" and id_stip='").append(strIdStIp).append("'");
				session.addBatch(sqlb.toString());
			}
			session.execBatch();
		}catch (DbException e) {
			throw new BizException("更新记账数据的医保状态失败，失败原因为："+e.getMessage());
		} finally {
			if (session != null)
				session.closeAll();

			if (persist != null)
				persist.release();
		}
	}
	/**
	 * 将该患者下医保交易明细放在map中
	 * @param strIdEnt
	 * @return
	 * @throws BizException
	 */
	private Map<String ,BlHpCgItmIpDo>setBlHpCgItmIpDoMap(String strIdEnt) throws BizException{
		Map<String, BlHpCgItmIpDo> map=new HashMap<>();
		List<String> entlist=new ArrayList<>();
		entlist.add(strIdEnt);
		//1. 判断是否母婴合并结算  且 获取就诊信息
		FBoolean isMerge =  BlParams.BLSTIP0005();
		IpStEP stEP = new IpStEP();
		//母婴合合并结算时，同时更新婴儿
		if(FBoolean.TRUE.equals(isMerge)){
			List<NewbornDO> list = (List<NewbornDO>)new DAFacade().findByAttrValString(NewbornDO.class, "Id_ent_mom", strIdEnt, null);
			if(list != null && !list.isEmpty()){
				//PatiVisitDO bbDo = stEP.getPatiEntInfo(list.get(0).getId_ent_bb());
				for (NewbornDO newbornDO : list) {
					entlist.add(newbornDO.getId_ent_bb());
				}
			} 				
		}
		IHpblllitmRService rService = ServiceFinder.find(IHpblllitmRService.class);
		BlHpCgItmIpDo[] blHpCgItmIpDos = rService.findByAttrValStrings(BlHpCgItmIpDo.ID_ENT, entlist.toArray(new String[0]));
		for (BlHpCgItmIpDo blHpCgItmIpDo : blHpCgItmIpDos) {
			map.put(blHpCgItmIpDo.getId_cgip(), blHpCgItmIpDo);
		}
		
		return map; 
	}
	
	/**
	 * 如果是母婴结算，就获取婴儿就诊主键
	 * @param idEntMm
	 * @return
	 * @throws DAException
	 */
	private String[] getBbIdEnts(String idEntMm) throws DAException{
		FBoolean isMerge =  BlParams.BLSTIP0005();
		if(FBoolean.TRUE.equals(isMerge) && StringUtils.isNotBlank(idEntMm)){
			String sql = "select id_ent_bb from EN_ENT_NB where id_ent_mom = ? ";
			SqlParam param = new SqlParam();
			param.addParam(idEntMm);
			DAFacade daf = new DAFacade();
			@SuppressWarnings("unchecked")
			List<String> idEntBbs = (List<String>) daf.execQuery(sql, param, new ColumnListHandler());
			if(idEntBbs != null && idEntBbs.size() > 0){
				return idEntBbs.toArray(new String[0]);
			}
		}
		return null;
	}
}
