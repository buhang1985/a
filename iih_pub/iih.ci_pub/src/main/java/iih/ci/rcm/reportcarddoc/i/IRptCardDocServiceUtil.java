package iih.ci.rcm.reportcarddoc.i;

import java.io.IOException;
import iih.ci.rcm.reportcarddoc.d.ReportCardDocDo;
import iih.ci.rcm.reportcarddoc.d.Reportcarddocdto;
import iih.ci.rcm.reportcarddocfs.d.ReportCardDocFsDo;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;


public interface IRptCardDocServiceUtil {
	
	/**
	 * 获取报卡文书流对象
	 * @param docDo
	 * @return
	 * @throws IOException 
	 * @throws BizException 
	 */
	public ReportCardDocFsDo getRptCardDocFs(ReportCardDocDo docDo) throws BizException, IOException;

	/**
	 * 保存报卡内容
	 * @param ciMrFsDO
	 * @param ciMrDO
	 * @return
	 * @throws BizException
	 */
	public FArrayList2 saveReportCardFsDO(ReportCardDocDo ciMrFsDO,ReportCardDocFsDo ciMrDO)  throws BizException ;
	
	/**
	 * 真实删除报卡文书
	 * @param docDo
	 * @return
	 */
	public FBoolean deleteRptCardDoc( ReportCardDocDo docDo);
	
	
	/**
	 * 查询报卡文书对应的DTO
	 * @1 用于按钮属性点击显示
	 * @param docDo
	 * @return
	 * @throws DAException 
	 * @throws BizException 
	 */
	public Reportcarddocdto findRptCardDocDTO( String docDoId) throws DAException, BizException;
	
	
	/**
	 * 分页查询报卡文书
	 * @param docId
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<Reportcarddocdto> findRptCardDtosByPageInfo(String whereStr,QryRootNodeDTO qryRootNodeDto,PaginationInfo paginationInfo) throws BizException;
	
	/**
	 * 导出按钮查询报卡数据
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	public Reportcarddocdto[]  findRptCardDtos(QryRootNodeDTO qryRootNodeDto) throws BizException;
	
	/**
	 * 报卡审核2.0 驳回消息提醒
	 * @author Jiasx
	 * @param reportcarddocdto
	 * @return 
	 * @throws BizException
	 */
	 public void reportRejectReminderMsg(Reportcarddocdto reportcarddocdto) throws BizException;
}
