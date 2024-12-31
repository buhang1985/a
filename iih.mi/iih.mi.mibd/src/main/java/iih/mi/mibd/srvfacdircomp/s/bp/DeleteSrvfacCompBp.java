package iih.mi.mibd.srvfacdircomp.s.bp;

import java.util.ArrayList;

import iih.mi.mibd.docenum.d.DirCompState;
import iih.mi.mibd.srvfacdircomp.d.SrvFacDirCompDO;
import iih.mi.mibd.srvfacdircomp.d.SrvfacDirCompDTO;
import iih.mi.mibd.srvfacdircomp.i.ISrvfacdircompCudService;
import iih.mi.mibd.srvfacdircomp.s.bp.adapter.SrvfacdircompDOAdapter;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/** 
* @author hexx 
* @version 创建时间：2018年2月8日 下午1:40:09 
* 类说明 
*/
public class DeleteSrvfacCompBp {

	public SrvfacDirCompDTO[] exec(String misId,SrvfacDirCompDTO[] SrvfacDirCompDTOs) throws BizException {	
		SrvfacDirCompDTO[] result =deleteSrvfacComp(misId,SrvfacDirCompDTOs);
		return result;
	}

	/**删除药品对照信息
	 * @param SrvfacDirCompDTOs
	 * @return
	 * @throws BizException 
	 */
	private SrvfacDirCompDTO[] deleteSrvfacComp(String misId,SrvfacDirCompDTO[] srvfacDirCompDtos) throws BizException {
		SrvFacDirCompDO[] srvFacDirCompDOs = ConvertDtoToDircompDOs(misId,srvfacDirCompDtos);
		deleteSrvfacDirComp(srvFacDirCompDOs);
		String[] srvfacIds = getSrvfacIds(srvfacDirCompDtos);
		SrvfacDirCompDTO[] SrvfacDirCompDTOs = findSrvfacCompBySrvfacId(misId,srvfacIds);
		return SrvfacDirCompDTOs;
	}

	/** 通过医保系统ID,查找数据DO，进行回显
	 * @param misId
	 * @param srvfacIds
	 * @return
	 * @throws BizException 
	 */
	private SrvfacDirCompDTO[] findSrvfacCompBySrvfacId(String misId,String[] srvfacIds) throws BizException {
		FindSrvfacCompBySrvfacIdBp bp = new FindSrvfacCompBySrvfacIdBp();
		SrvfacDirCompDTO[] srvfacDirComps = bp.exec(misId,srvfacIds);
		return srvfacDirComps;
	}

	/**获取ID集合
	 * @param SrvfacDirCompDTOs
	 * @return
	 */
	private String[] getSrvfacIds(SrvfacDirCompDTO[] SrvfacDirCompDTOs) {
		ArrayList<String> ids = new ArrayList<String>();
		for (SrvfacDirCompDTO dto : SrvfacDirCompDTOs) {
			ids.add(dto.getId_srv());
		}
		return ids.toArray(new String[0]);
	}

	/**通过调用基础服务删除适配器处理生成的DO
	 * @param srvFacDirCompDOs
	 * @throws BizException
	 */
	private void deleteSrvfacDirComp(SrvFacDirCompDO[] srvFacDirCompDOs) throws BizException {
		ISrvfacdircompCudService srvfacdircompCudService = ServiceFinder.find(ISrvfacdircompCudService.class);
		srvfacdircompCudService.delete(srvFacDirCompDOs);
	}

	/**通过适配器，把DTO中的数据转移到DO中
	 * @param SrvfacDirCompDTOs
	 * @return
	 */
	private SrvFacDirCompDO[] ConvertDtoToDircompDOs(String misId,SrvfacDirCompDTO[] srvfacDirCompDtos) {
		ArrayList<SrvFacDirCompDO> srvfacDirCompDoList = new ArrayList<SrvFacDirCompDO>();
		SrvfacdircompDOAdapter adapter = new SrvfacdircompDOAdapter();
		for (SrvfacDirCompDTO compDTO : srvfacDirCompDtos) {
			SrvFacDirCompDO srvFacDirCompDO = adapter.getSrvfacdircompDO(misId, compDTO);
			srvFacDirCompDO.setEu_status(DirCompState.NOT_COMP);
			srvFacDirCompDO.setStatus(DOStatus.DELETED);
			srvfacDirCompDoList.add(srvFacDirCompDO);
		}
		return srvfacDirCompDoList.toArray(new SrvFacDirCompDO[0]);
	}
}
