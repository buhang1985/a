package iih.en.comm.ep;

import iih.bd.fc.queben.d.QueBenDO;
import iih.bd.fc.queben.i.IQuebenCudService;
import iih.bd.fc.queben.i.IQuebenRService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 队列工作台公共EP
 * @author fanlq
 * @date: 2019年9月6日 上午10:37:41
 */
public class BdQueBenEP {
	
	/***
	 * @Description:通过主键id获取队列工作台
	 * @param id_queben
	 * @return
	 * @throws BizException
	 */
	public QueBenDO findById(String id_queben) throws BizException{
		return getQueRServ().findById(id_queben);
	}
	
	/***
	 * @Description:通过就诊id获取对应的队列工作台
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public QueBenDO getQueBenByEntId(String id_ent) throws BizException{
		StringBuffer sql = new StringBuffer();
		SqlParam param = new SqlParam();
		sql.append("select ben.* ");
		sql.append("from en_ent ent " );
		sql.append("inner join pi_pat pat on pat.id_pat = ent.id_pat " );
		sql.append("inner join en_ent_op op on op.id_ent = ent.id_ent " );
		sql.append("inner join sc_sch sch on sch.id_sch = op.id_sch " );
		sql.append("inner join sc_pl pl on pl.id_scpl = sch.id_scpl " );
		sql.append("inner join bd_que_ben ben on ben.id_queben = pl.id_queben " );
		sql.append("where ent.id_ent = ? ");
		param.addParam(id_ent);
		@SuppressWarnings("unchecked")
		List<QueBenDO> list = (List<QueBenDO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(QueBenDO.class));
		return list != null && list.size() > 0 ? list.toArray(new QueBenDO[0])[0]:null;
	}
	/**
	 * 获取队列工作台查询服务
	 * 
	 * @return
	 */
	public IQuebenRService getQueRServ() {
		return ServiceFinder.find(IQuebenRService.class);
	}
	/**
	 * 获取队列工作台CUD服务
	 * 
	 * @return
	 */
	public IQuebenCudService getQueCudServ() {
		return ServiceFinder.find(IQuebenCudService.class);
	}
}
