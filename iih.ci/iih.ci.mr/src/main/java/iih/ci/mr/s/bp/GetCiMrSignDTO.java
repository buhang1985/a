package iih.ci.mr.s.bp;

import java.util.List;

import iih.ci.mr.d.MrSginDTO;
import iih.ci.mr.s.bp.qry.CiMrsignsql;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.permfw.user.i.IUserRService;
import xap.wf.af.itf.IWfTaskQry;

public class GetCiMrSignDTO extends PagingServiceImpl<MrSginDTO>{
	private IWfTaskQry service = ServiceFinder.find(IWfTaskQry.class);
	private  IUserRService userService=ServiceFinder.find(IUserRService.class);
	/**
	 *  获取审签任务DTO
	 * @param id_user
	 * @param state
	 * @return MrSginDTO
	 * @throws BizException
	 */
	public PagingRtnData<MrSginDTO> exec(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException{
		
		CiMrsignsql Sql = new CiMrsignsql(qryRootNodeDTO);
		PagingRtnData<MrSginDTO> pagingRtnData = super.findByPageInfo(new MrSginDTO(), paginationInfo, Sql.getQrySQLStr(), " order by mr_modifiedtime DESC", null);
		setUser(pagingRtnData);
		return pagingRtnData;
	}
	
	public void setUser(PagingRtnData<MrSginDTO> pagingRtnData) throws BizException
	{
		List<MrSginDTO> data=pagingRtnData.getPageData();
		//pagingRtnData.get
		
		for(MrSginDTO dto : data)
		{
			String iduser= service.getPreTasksUser(dto.getId_task());
			String name=userService.findById(iduser).getName();
			dto.setMr_modifiedby(name);
//			if(dto.getState().equals("Todo"))
//			{
//				dto.setState("待完成任务");
//			}
//			if(dto.getState().equals("Completed"))
//			{
//				dto.setState("已完成任务");
//			}
//			if(dto.getState().equals("Run"))
//			{
//				dto.setState("任务执行中");
//			}
		}
		
	}

}
