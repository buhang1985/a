package iih.bl.cg.s.listener;

import java.util.List;

import iih.bl.cg.blcghist.s.bp.SaveCgIpHistBP;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.comm.IBlMsgConst;
import iih.en.pv.inpatient.dto.d.ChgHp4EsDTO;
import iih.en.pv.inpatient.dto.d.EuChgHpTp;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 自费转医保住院记账自费标识监听器
 * @author hanjq 上午11:26:06
 *
 */
public class HpEntIpListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 1、获取事件源
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		ChgHp4EsDTO chgHp4EsDTO = (ChgHp4EsDTO) bizUserObj.getUserObj();
		if (chgHp4EsDTO == null) {
			Logger.error(IBlMsgConst.ERROR_EVENT_SOURCE_IS_NULL);
			return;
		}
		//2.修改自费标识
		if(EuChgHpTp.SELFTOHPPAY.equals(chgHp4EsDTO.getEu_chghp())){
			setBlCgIpFgSelfPay(chgHp4EsDTO);
		}
	}
	
	/**
	 * 修改自费标识
	 * @author : hanjq 2019年9月12日 下午2:01:47
	 * @param chgHp4EsDTO
	 * @throws BizException 
	 */
	private void setBlCgIpFgSelfPay(ChgHp4EsDTO chgHp4EsDTO) throws BizException{
		DAFacade daf = new DAFacade();
		String sql = getSql(chgHp4EsDTO.getId_ent());
		List<BlCgIpDO> cgIps = null;
		SaveCgIpHistBP hisBp = new SaveCgIpHistBP();
		while((cgIps = (List<BlCgIpDO>) daf.execQuery(sql, new BeanListHandler(BlCgIpDO.class))) != null && cgIps.size() > 0){
			for(BlCgIpDO cg:cgIps){
				cg.setStatus(DOStatus.UPDATED);
				if(FBoolean.TRUE.equals(cg.getFg_selfpay())){
					cg.setFg_selfpay(FBoolean.FALSE);
				}else{
					cg.setFg_selfpay(FBoolean.TRUE);
				}
			}
			daf.updateDOArray(cgIps.toArray(new BlCgIpDO[0]), new String[]{BlCgIpDO.FG_SELFPAY});
			hisBp.saveHistory(cgIps, "02","HpEntIpListener");//临床医嘱修改
		}
	}
	
	/**
	 * 获取住院记账数据--自费标识是反向的
	 * @author : hanjq 2019年9月12日 下午1:41:01
	 * @param id_ent
	 * @return
	 */
	private String getSql(String id_ent){
		StringBuilder bl = new StringBuilder();
		bl.append("select distinct cgip.id_cgip,cgip.fg_selfpay from( ");
		bl.append(" select cg.id_cgip,cg.fg_selfpay ,nvl(hpsrv.sd_hpsrvtp,'3') sd_hpsrvtp ");
		bl.append("	from bl_cg_ip cg ");
		bl.append("	join en_ent ent on ent.id_ent = cg.id_ent ");
		bl.append(" left join BD_HP_SRVORCA hpsrv on ent.id_hp = hpsrv.id_hp and ");
		bl.append("   decode(cg.id_mm,'~','~',cg.id_srv ,cg.id_mm ) = decode(cg.id_mm,'~',hpsrv.id_srv ,hpsrv.id_mm ) ");
		bl.append(" where ent.id_ent = '").append(id_ent).append("' ) cgip ");
		bl.append("where rownum < 2000 ");
		bl.append("and ((cgip.sd_hpsrvtp = '3' and cgip.fg_selfpay = 'N') ");
		bl.append(" or (cgip.sd_hpsrvtp in ('1','2') and cgip.fg_selfpay = 'Y')) ");
		return bl.toString();		
	}

}
