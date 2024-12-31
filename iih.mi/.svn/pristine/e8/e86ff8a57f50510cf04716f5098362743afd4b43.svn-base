package iih.mi.mibd.srvfacdircomp.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.mi.mibd.docenum.d.DirCompState;
import iih.mi.mibd.srvfacdircomp.d.SrvFacDirCompDO;
import iih.mi.mibd.srvfacdircomp.d.SrvfacDirCompDTO;
import iih.mi.mibd.srvfacdircomp.i.ISrvfacdircompCudService;
import iih.mi.mibd.srvfacdircomp.s.bp.adapter.SrvfacdircompDOAdapter;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存服务设施对照逻辑
 *
 *@author hexx
 */
public class SaveSrvfacCompBp {

	
	/**
	 * @param misId
	 * @param srvfacDirCompDTOs
	 * @return
	 * @throws BizException
	 */
	public SrvfacDirCompDTO[] exec(String misId, SrvfacDirCompDTO[] srvfacDirCompDTOs) throws BizException{
		if (StringUtils.isEmpty(misId)) {
			throw new BizException("医保系统不允许为空");
		}
		if(srvfacDirCompDTOs == null || srvfacDirCompDTOs.length <= 0){
			
			throw new BizException("没有需要保存的服务设施名称");
		}
		 SrvfacDirCompDTO[] result  = saveSrvfacComp(misId,srvfacDirCompDTOs);
		 return result;
	}
	
	
	/**保存服务对对照信息
	 * @param misId
	 * @param srvfacDirCompDTOs
	 * @return
	 * @throws BizException
	 */
	private SrvfacDirCompDTO[] saveSrvfacComp(String misId, SrvfacDirCompDTO[] srvfacDirCompDTOs) throws BizException {
		SrvFacDirCompDO[] SrvFacDirCompDOs = ConvertDtoToDircompDOs(misId,srvfacDirCompDTOs);
		saveSrvfacDirComp(SrvFacDirCompDOs);
		String[] srvfacIds = getSrvfacIds(srvfacDirCompDTOs);
		SrvfacDirCompDTO[] srvfacDirCompDtos = findSrvfacCompBySrvfacId(misId, srvfacIds);
		return srvfacDirCompDtos;
	}
	
	
	/**通过适配器，把DTO中的数据转移到DO中
	 * @param misId
	 * @param srvfacDirCompDTOs
	 * @return
	 */
	public SrvFacDirCompDO[] ConvertDtoToDircompDOs(String misId, SrvfacDirCompDTO[] srvfacDirCompDTOs){
		ArrayList<SrvFacDirCompDO> SrvFacDirCompDOList = new ArrayList<SrvFacDirCompDO>();
		SrvfacdircompDOAdapter adapter = new SrvfacdircompDOAdapter();
		for (SrvfacDirCompDTO compDTO : srvfacDirCompDTOs) {
			SrvFacDirCompDO srvfacdircompDO = adapter.getSrvfacdircompDO(misId, compDTO);
			srvfacdircompDO.setEu_status(DirCompState.COMPED);
			if (StringUtils.isNotEmpty(srvfacdircompDO.getId_comp_srvfac())) {
				srvfacdircompDO.setStatus(DOStatus.UPDATED);
			} else {
				srvfacdircompDO.setStatus(DOStatus.NEW);
			}
			SrvFacDirCompDOList.add(srvfacdircompDO);
		}
		return SrvFacDirCompDOList.toArray(new SrvFacDirCompDO[0]);
	}
	
	
	/**通过调用基础服务保存适配器处理生成的DO
	 * @param SrvFacDirCompDOs
	 * @return
	 * @throws BizException
	 */
	private SrvFacDirCompDO[] saveSrvfacDirComp(SrvFacDirCompDO[] SrvFacDirCompDOs) throws BizException {
		ISrvfacdircompCudService srvfacdircompCudService= ServiceFinder.find(ISrvfacdircompCudService.class);
		SrvFacDirCompDO[] result = srvfacdircompCudService.save(SrvFacDirCompDOs);
		return result;
	}
	
	
	/**通过医保系统ID,查找保存过的数据DO，进行回显
	 * @param misId
	 * @param srvfacIds
	 * @return
	 * @throws BizException
	 */
	private SrvfacDirCompDTO[] findSrvfacCompBySrvfacId(String misId, String[] srvfacIds) throws BizException {
		FindSrvfacCompBySrvfacIdBp bp = new FindSrvfacCompBySrvfacIdBp();
		SrvfacDirCompDTO[] srvfacDirCompDTOs = bp.exec(misId, srvfacIds);
		return srvfacDirCompDTOs;
	}
	
	
	/**获取IDs集合
	 * @param srvfacDirCompDTOs
	 * @return
	 */
	private String[] getSrvfacIds(SrvfacDirCompDTO[] srvfacDirCompDTOs) {
		ArrayList<String> ids = new ArrayList<String>();
		for (SrvfacDirCompDTO dto : srvfacDirCompDTOs) {
			ids.add(dto.getId_srv());
		}
		return ids.toArray(new String[0]);
	}
}
