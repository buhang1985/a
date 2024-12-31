package iih.ci.ord.s.bp.ordsrvchangedval;

import java.util.ArrayList;
import java.util.Set;

import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 判断服务是否可开立
 * 
 * @author zhangwq
 *
 */
public class OrdSrvValidateBP extends OrdChangedSrvValidateBP {
	public OrdSrvValidateBP() throws BizException {
		super();
	}

	/**
	 * 服务停用判断\服务临床标识判断
	 * @throws BizException 
	 */
	protected void judgeSrvActive() throws BizException {
		if (null == mapMeSrvDOs_Checked || 0 >= mapMeSrvDOs_Checked.size())
			return;

		Set<String> id_srvs = mapMeSrvDOs_Checked.keySet();
		String msg=getOpenItemMaintainerValidate();
		for (String id_srv : new ArrayList<>(id_srvs)) {

			MedSrvDO meSrvDO = (MedSrvDO) mapMeSrvDOs_Checked.get(id_srv);

			if (!FBoolean.TRUE.equals(meSrvDO.getFg_active()) && FBoolean.TRUE.equals(meSrvDO.getFg_or())) {
				mapResult.put(id_srv, String.format(STR_SRV_ACTIVE_VAL+msg, meSrvDO.getName()));
				mapMeSrvDOs_Checked.remove(id_srv);
			}
		}
	}
}
