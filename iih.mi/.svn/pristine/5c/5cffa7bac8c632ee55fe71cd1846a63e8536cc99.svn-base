package iih.mi.biz.s.hpsign;

import iih.mi.biz.hpsignin.d.MiHpSignInDO;
import iih.mi.biz.i.hpsign.IMiHpSignService;
import iih.mi.biz.s.hpsign.bp.GetHpSignArrayBp;
import iih.mi.biz.s.hpsign.bp.GetHpSignListBP;
import iih.mi.biz.s.hpsign.bp.MiHpSignInBP;
import iih.mi.biz.s.hpsign.bp.MiHpSignOutBP;
import iih.mi.biz.signinfo.dto.d.MiSignInfoDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 医保签到服务
 * @author ly 2018/03/14
 *
 */
@Service(serviceInterfaces={IMiHpSignService.class}, binding=Binding.JSONRPC)
public class MiHpSignServiceImpl implements IMiHpSignService {

	/**
	 * 签到
	 * @param empId 操作员ID
	 * @param bizCode 业务周期号
	 * @param bizType 业务类型
	 * @throws BizException
	 */
	@Override
	public void signIn(String empId, String bizCode, Integer bizType,String mac,String strIdHp) throws BizException {
		MiHpSignInBP bp = new MiHpSignInBP();
		bp.exec(empId, bizCode, bizType, mac,strIdHp);
	}

	/**
	 * 签退
	 * @param empId操作员ID
	 * @param bizType 业务类型
	 * @throws BizException
	 */
	@Override
	public void signOut(String empId,String bizNo) throws BizException {
		MiHpSignOutBP bp = new MiHpSignOutBP();
		bp.exec(empId,bizNo);
	}

	/**
	 * 获取操作员签到记录
	 * 
	 * @param pg
	 *            分页对象
	 * @param empId
	 *            操作员ID
	 * @return 签到记录集合
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<MiHpSignInDO> getHpSignList(PaginationInfo pg, String whereCond) throws BizException {
		GetHpSignListBP handlerBp=new GetHpSignListBP();
		return handlerBp.exec(pg, whereCond);
	}

	@Override
	public MiSignInfoDTO[] getHpSignInfoList(String empId, String id_hp, String bizType) throws BizException {
		GetHpSignArrayBp handlerBp=new GetHpSignArrayBp();
		return handlerBp.exec(empId, id_hp, bizType);
	}
	
	
}
