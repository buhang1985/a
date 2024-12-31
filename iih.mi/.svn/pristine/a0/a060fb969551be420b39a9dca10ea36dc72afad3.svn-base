package iih.mi.mc.s.bp;

import iih.bd.base.utils.AppUtils;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;

import java.util.List;

import org.apache.cxf.common.util.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;


/**
 * 医嘱共享校验接口
 * （由于医保平台返回的信息不是实时更新的（医保两小时同步一次），
 * 所以为ci提供接口判断当天就诊中是否存在退费数据，如果存在，则不限制医嘱开立）
 * @author LIM
 *
 */
public class MiMcBlCgHasOpRefundRecordBP {

	/**
	 * 查询患者该医保计划下的物品退费数量是否大于收费数量
	 * @param patId 患者id
	 * @param hpId 医保id
	 * @param mmId 物品id
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String patId,String hpId,String mmId) throws BizException{
		
		FBoolean bExist=FBoolean.FALSE;
		//1.校验参数是否为空
		this.valid(patId, hpId,mmId);
		//2.查询此物品是否有过退药记录
		bExist=getRtnMMInfo(patId,mmId,hpId);
		return bExist;
	}
	
	/**
	 * 参数校验
	 * @param patId
	 * @param hpId
	 * @param mmId
	 * @throws BizException
	 */
	private void valid(String patId,String hpId,String mmId) throws BizException{
		if(StringUtils.isEmpty(patId)){
			throw new BizException("患者ID不能为空！");
		}
		
		if(StringUtils.isEmpty(hpId)){
			throw new BizException("医保ID不能为空！");
		}
		
		if(StringUtils.isEmpty(mmId)){
			throw new BizException("物品ID不能为空！");
		}
	}
	
	/**
	 * 
	 * @return
	 * @throws BizException 
	 */
	private FBoolean getRtnMMInfo(String patId,String mmId,String id_hp) throws BizException{
		String sql = this.getSql();
		SqlParam param = new SqlParam();
		param.addParam(AppUtils.getServerDate());
		param.addParam(id_hp);
		param.addParam(patId);
		param.addParam(mmId);
		
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<BlCgItmOepDO> result = (List<BlCgItmOepDO>)daf.execQuery(sql, param, new BeanListHandler(BlCgItmOepDO.class));
		
		if(ListUtil.isEmpty(result)){
			return FBoolean.FALSE;
		}
		
		return result.get(0).getQuan().doubleValue()<=0 ?FBoolean.TRUE:FBoolean.FALSE;
	}
	
	
	/**
	 * 获取查询sql
	 * 查询医保内的数据，暂时不考虑once 后续得修改
	 * @return 
	 */
	private String getSql(){
		StringBuilder sb= new StringBuilder();
		sb.append("select nvl(sum(cg.eu_direct* itm.quan),0) as quan ");
		sb.append(" from bl_cg_oep cg ");
		sb.append(" inner join bl_cg_itm_oep itm on cg.id_cgoep=itm.id_cgoep ");
		sb.append(" inner join en_ent_hp hp on itm.id_ent= hp.id_ent ");
		sb.append(" inner join ci_or_srv srv on itm.id_orsrv=srv.id_orsrv ");
		sb.append(" where srv.fg_selfpay='N' and substr(cg.dt_cg,1,10)=?");
		sb.append(" and hp.id_hp=? ");
		sb.append(" and itm.id_pat=? ");
		sb.append(" and itm.id_mm=? ");
		return sb.toString();
	}
}
