package iih.sc.sch.s.ep;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.sch.sclock.d.ScSchLockDO;
import iih.sc.sch.sclock.d.desc.ScSchLockDODesc;
import iih.sc.sch.sclock.i.IScschlockdoCudService;
import iih.sc.sch.sclock.i.IScschlockdoRService;
import iih.sc.sch.scsch.d.ScSchDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/***
 * 排班锁EP
 * @author fanlq
 * @date: 2019年10月21日 下午4:23:55
 */
public class SchLockEP {
	/***
	 * @Description:获取门诊排班
	 * @param scSchLockDOs
	 * @return
	 * @throws BizException 
	 */
	public ScSchDO[] getSchByLock(ScSchLockDO[] scSchLockDOs,String sd_sctp) throws BizException{
		List<ScSchDO> scSchDOList = new ArrayList<ScSchDO>();
		if(scSchLockDOs != null && scSchLockDOs.length >0 && !StringUtils.isNullOrEmpty(sd_sctp)){
			List<String> id_schlist = new ArrayList<String>();
			for(ScSchLockDO schlock : scSchLockDOs){
				id_schlist.add(schlock.getId_sch());
			}
			 ScSchDO[] schs = new SchEP().getByPKs(id_schlist.toArray(new String[]{}));
			 if(schs != null && schs.length > 0){
				 for(ScSchDO sch : schs){
					 if(sd_sctp.equals(sch.getSd_sctp())){
						 scSchDOList.add(sch);
					 }
				 }
			 }
		}
		return scSchDOList.size() > 0 ? scSchDOList.toArray(new ScSchDO[]{}):null;
	}
	/***
	 * @Description:根据where条件查询排班锁表
	 * @param whereStr
	 * @return
	 * @throws BizException
	 */
	public ScSchLockDO[] getLockList(String whereStr) throws BizException{
		ScSchLockDO[] scSchLockDOs = this.getRServ().find(" 1=1 " + whereStr,ScSchLockDODesc.TABLE_ALIAS_NAME+".dt_b_lock desc", FBoolean.FALSE);
		return scSchLockDOs;
	}
	/***
	 * @Description:根据主键id查排班锁
	 * @param lockDO
	 * @throws BizException
	 */
	public ScSchLockDO findById(String id_schlock) throws BizException{
		return this.getRServ().findById(id_schlock);
	}
	/***
	 * @Description:保存排班锁
	 * @param lockDO
	 * @throws BizException
	 */
	public void save(ScSchLockDO lockDO) throws BizException{
		this.getCudServ().save(new ScSchLockDO[]{lockDO});
	}
	/**
	 * 获取主DO查询服务
	 * 
	 * @return
	 */
	public IScschlockdoCudService getCudServ(){
		return ServiceFinder.find(IScschlockdoCudService.class);
	}
	
	/**
	 * 获取查询服务
	 * 
	 * @return
	 */
	public IScschlockdoRService getRServ(){
		return ServiceFinder.find(IScschlockdoRService.class);
	}
}
