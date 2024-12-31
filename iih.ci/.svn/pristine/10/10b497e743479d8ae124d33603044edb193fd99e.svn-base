package iih.ci.rcm.reportcarddoc.s;

import java.io.IOException;
import iih.ci.rcm.reportcarddoc.d.ReportCardDocDo;
import iih.ci.rcm.reportcarddoc.d.Reportcarddocdto;
import iih.ci.rcm.reportcarddoc.i.IRptCardDocServiceUtil;
import iih.ci.rcm.reportcarddocfs.d.ReportCardDocFsDo;
import iih.ci.rcm.reportrejectedremind.bp.ReportRejectedRemindBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces = { IRptCardDocServiceUtil.class }, binding = Binding.JSONRPC)
public class RptCardDocServiceUtilImpl implements IRptCardDocServiceUtil {

	ReportCardUtil _rptCardUtil;
	
	public RptCardDocServiceUtilImpl()
	{
		this._rptCardUtil = new ReportCardUtil();
	}
	
	/**
	 * 保存报卡内容
	 * @param ciMrFsDO
	 * @param ciMrDO
	 * @return
	 * @throws BizException
	 */
	public FArrayList2 saveReportCardFsDO(ReportCardDocDo docDo,ReportCardDocFsDo docFsDo) throws BizException  
	{
		return this._rptCardUtil.saveReportCardDoc(docDo, docFsDo);
	}
	

	/**
	 * 获取报卡文书流对象
	 * @param docDo 报卡文书对象
	 * @return
	 * @throws BizException 
	 * @throws IOException 
	 */
	public ReportCardDocFsDo getRptCardDocFs(ReportCardDocDo docDo ) throws BizException, IOException
	{
		return this._rptCardUtil.getRptCardDocFs(docDo);
	}
	

	/**
	 * 真实删除报卡文书
	 * @param docDo
	 * @return
	 */
	public FBoolean deleteRptCardDoc( ReportCardDocDo docDo)
	{
		return this._rptCardUtil.deleteRptCardDoc(docDo);
	}
	
	/**
	 * 查询报卡文书对应的DTO
	 * @1 用于按钮属性点击显示
	 * @param docDo
	 * @return
	 * @throws BizException 
	 */
	public Reportcarddocdto findRptCardDocDTO( String docId) throws BizException
	{
		return this._rptCardUtil.findRptCardDocDTO(docId);
	}

	
	/**
	 * 分页查询报卡文书
	 * @param docId
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<Reportcarddocdto> findRptCardDtosByPageInfo(String whereStr,QryRootNodeDTO qryRootNodeDto,PaginationInfo paginationInfo) throws BizException
	{
		return this._rptCardUtil.findRptCardDtosByPageInfo(whereStr,qryRootNodeDto, paginationInfo);
	}
	
	/**
	 * 导出按钮查询报卡数据
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	public Reportcarddocdto[] findRptCardDtos(QryRootNodeDTO qryRootNodeDto) throws BizException
	{
		return this._rptCardUtil.findRptCardDtos(qryRootNodeDto);
	}

	/**
	 * 报卡审核2.0 驳回消息提醒
	 * @author Jiasx
	 * @param reportcarddocdto
	 * @return 
	 * @throws BizException
	 */
	@Override
	public void reportRejectReminderMsg(Reportcarddocdto reportcarddocdto) throws BizException {
		ReportRejectedRemindBp bp=new ReportRejectedRemindBp();
		bp.reportRejectReminderMsg(reportcarddocdto);
	}
	
	
}
