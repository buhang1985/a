package iih.mi.biz.i.hpsign;

import iih.mi.biz.hpsignin.d.MiHpSignInDO;
import iih.mi.biz.signinfo.dto.d.MiSignInfoDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 医保签到服务
 * @author ly 2018/03/14
 *
 */
public interface IMiHpSignService {

	/**
	 * 签到
	 * @param empId 操作员ID
	 * @param bizCode 业务周期号
	 * @param bizType 业务类型
	 * @param mac mac地址
	 * @throws BizException
	 */
	public abstract void signIn(String empId,String bizCode,Integer bizType,String mac,String strIdHp) throws BizException;
	
	/**
	 * 签退
	 * @param empId操作员ID
	 * @param bizType 业务类型
	 * @throws BizException
	 */
	public abstract void signOut(String empId,String bizNo) throws BizException;
	
	/** 获取签到分页数据
	 * @param pg
	 * @param whereCond 条件
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<MiHpSignInDO> getHpSignList(PaginationInfo pg, String whereCond) throws BizException;

	/** 获取签到信息
	 * @param empId 人员信息
	 * @param id_hp 医保产品
	 * @param bizType 业务类型
	 * @return
	 * @throws BizException
	 */
	public abstract MiSignInfoDTO[] getHpSignInfoList(String empId,String id_hp,String bizType) throws BizException;
}
