package iih.bd.mm.supplierprotocol.s.ds;

import java.util.HashMap;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.supplierprotocol.d.ProtocolGoodsDO;
import iih.bd.mm.supplierprotocol.d.SuppierProtocolDO;
import iih.bd.mm.supplierprotocol.d.SupplierprotocolAggDO;
import iih.bd.mm.supplierprotocol.i.ISupplierprotocolRService;
import xap.lui.core.cache.XapCacheMgr;
import xap.lui.core.mq.MQMessage;
import xap.lui.core.mq.MQSender;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class SupplierProtocolCache {
	
	public static final String BD_MM_SUPPRO_KEY = "BD_MM_SUPPRO_KEY";
	public static final String BD_MM_SUPPRO_PRICE_KEY = "BD_MM_SUPPRO_PRICE_KEY";
	
	public static final String UPDATE_BD_MM_SUPPRO_KEY = "UPDATE_BD_MM_SUPPRO_KEY";
	public static final String CLEAR_BD_MM_SUPPRO_KEY = "CLEAR_BD_MM_SUPPRO_KEY";
	
	private ISupplierprotocolRService supplierProSrv;
	
	private static SupplierProtocolCache instance;
	private static Object lockObject = new Object();
	
	public static synchronized SupplierProtocolCache getInstance() throws BizException {
		if (instance == null) {
			synchronized (lockObject) {
				if (instance == null) {
					// 单例模式必须加锁，防止重复构造
					// 必须进行二次判空，否则也会出现重复构造
					instance = new SupplierProtocolCache();
				}
			}
		}
		return instance;
	}
	
	public SupplierProtocolCache() throws BizException {
		
		this.supplierProSrv = ServiceFinder.find(ISupplierprotocolRService.class);
		this.loadSupplierProtocol();
	}
	
	private void loadSupplierProtocol() throws BizException {
		
		String whrStr = String.format("sd_su_prot = '%s' and fg_active = 'Y'", IBdMmDictCodeConst.SD_SU_PROT_PASS);
		SupplierprotocolAggDO[] supProAggDOS = supplierProSrv.find(whrStr, SuppierProtocolDO.SD_PRIORITY, FBoolean.FALSE);
		if(supProAggDOS == null || supProAggDOS.length <= 0) {
			
			return;
		}
		
		for(SupplierprotocolAggDO supProAggDO : supProAggDOS) {
			
			this.putSupproCache(supProAggDO);
		}
	}

	@SuppressWarnings("unchecked")
	private void putSupproCache(SupplierprotocolAggDO supProAggDO) {
		
		ProtocolGoodsDO[] supPriceDOS = supProAggDO.getProtocolGoodsDO();
		if(supPriceDOS == null || supPriceDOS.length <= 0) {
			
			return;
		}
		
		for(ProtocolGoodsDO supPriceDO : supPriceDOS) {
			
			String supproKey = this.getSupproKey(supProAggDO.getParentDO().getId_sup(), supPriceDO.getId_mm());
			String pricekey = this.getPriceKey(supProAggDO.getParentDO().getId_sup(), supPriceDO.getId_mm(), 
					supProAggDO.getParentDO().getId_sup_prot());
			if(XapCacheMgr.getStrongCacheOnlyLocal(BD_MM_SUPPRO_KEY).getKeys().contains(supproKey)) {
				
				Object value = XapCacheMgr.getStrongCacheOnlyLocal(BD_MM_SUPPRO_KEY).get(supproKey);
				Map<String, SuppierProtocolDO> supproDOS = (Map<String, SuppierProtocolDO>)value;
				supproDOS.put(supProAggDO.getParentDO().getId_sup_prot(), supProAggDO.getParentDO());
			} else {
				
				Map<String, SuppierProtocolDO> supproDOS = new HashMap<String, SuppierProtocolDO>();
				supproDOS.put(supProAggDO.getParentDO().getId_sup_prot(), supProAggDO.getParentDO());
				XapCacheMgr.getStrongCacheOnlyLocal(BD_MM_SUPPRO_KEY).put(supproKey, supproDOS);
			}
			
			XapCacheMgr.getStrongCacheOnlyLocal(BD_MM_SUPPRO_PRICE_KEY).put(pricekey, supPriceDO);
		}
	}

	private String getSupproKey(String id_sup, String id_mm) {
		
		return id_sup + " " + id_mm;
	}
	
	private String getPriceKey(String id_sup, String id_mm, String id_sup_prot) {
		
		return id_sup + " " + id_mm + " " + id_sup_prot;
	}
	
	public void updateCache(SupplierprotocolAggDO[] supProAggDOS) {
		
		MQMessage mqMessage=new MQMessage(UPDATE_BD_MM_SUPPRO_KEY, supProAggDOS);
		MQSender.sendMsgForAdapter(mqMessage);
	}
	
	public void updateMmSupproCache(SupplierprotocolAggDO[] supProAggDOS) {
		
		for(SupplierprotocolAggDO supProAggDO : supProAggDOS) {
			
			this.putSupproCache(supProAggDO);
		}
	}
	
	public void deleteCache(SupplierprotocolAggDO[] supProAggDOS) {
		
		MQMessage mqMessage=new MQMessage(CLEAR_BD_MM_SUPPRO_KEY, supProAggDOS);
		MQSender.sendMsgForAdapter(mqMessage);
	}
	
	public void deleteMmSupproCache(SupplierprotocolAggDO[] supProAggDOS) {
		
		for(SupplierprotocolAggDO supProAggDO : supProAggDOS) {
			
			this.delSupproCache(supProAggDO);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void delSupproCache(SupplierprotocolAggDO supProAggDO) {
		
		ProtocolGoodsDO[] supPriceDOS = supProAggDO.getProtocolGoodsDO();
		if(supPriceDOS == null || supPriceDOS.length <= 0) {
			
			return;
		}
		
		for(ProtocolGoodsDO supPriceDO : supPriceDOS) {
			
			String supproKey = this.getSupproKey(supProAggDO.getParentDO().getId_sup(), supPriceDO.getId_mm());
			String pricekey = this.getPriceKey(supProAggDO.getParentDO().getId_sup(), supPriceDO.getId_mm(), 
					supProAggDO.getParentDO().getId_sup_prot());
			
			if(XapCacheMgr.getStrongCacheOnlyLocal(BD_MM_SUPPRO_KEY).getKeys().contains(supproKey)) {
				
				Object value = XapCacheMgr.getStrongCacheOnlyLocal(BD_MM_SUPPRO_KEY).get(supproKey);
				Map<String, SuppierProtocolDO> supproDOS = (Map<String, SuppierProtocolDO>)value;
				if(supproDOS.containsKey(supPriceDO.getId_sup_prot())) {
					
					supproDOS.remove(supPriceDO.getId_sup_prot());
				}
			}
			
			if(XapCacheMgr.getStrongCacheOnlyLocal(BD_MM_SUPPRO_PRICE_KEY).getKeys().contains(pricekey)) {
				
				XapCacheMgr.getStrongCacheOnlyLocal(BD_MM_SUPPRO_PRICE_KEY).remove(pricekey);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public FDouble getMmSupproPrice(String id_sup, String id_mm, FDate date_reqr) throws BizException {
		
		String supproKey = this.getSupproKey(id_sup, id_mm);
		Object value = XapCacheMgr.getStrongCacheOnlyLocal(BD_MM_SUPPRO_KEY).get(supproKey);
		Map<String, SuppierProtocolDO> supproDOS = (Map<String, SuppierProtocolDO>)value;
		if(supproDOS == null || supproDOS.size() <= 0) {
			
			return null;
		}
		
		SuppierProtocolDO supproDO = null;
		for(SuppierProtocolDO supprodo : supproDOS.values()) {
			if(!supprodo.getFg_active().booleanValue()) {
				continue;
			}
			if(supprodo.getDa_b().asLocalBegin().compareTo(date_reqr.asLocalBegin()) <= 0 && 
					supprodo.getDa_e().asLocalBegin().compareTo(date_reqr.asLocalBegin()) >=0) {
				
				if(supproDO == null || supprodo.getSd_priority().compareTo(supproDO.getSd_priority()) <= 0) {
					
					supproDO = supprodo;
				}
			}
		}
		if(supproDO == null) {
			
			return null;
		}
		
		String priceKey = this.getPriceKey(id_sup, id_mm, supproDO.getId_sup_prot());
		ProtocolGoodsDO goodsDO = (ProtocolGoodsDO)XapCacheMgr.getStrongCacheOnlyLocal(BD_MM_SUPPRO_PRICE_KEY).get(priceKey);
		return goodsDO.getPrice();
	}
}
