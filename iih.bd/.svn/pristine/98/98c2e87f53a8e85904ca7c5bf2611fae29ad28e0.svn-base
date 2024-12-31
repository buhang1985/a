package iih.bd.srv.emrterm.s;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.emrterm.d.EmrEtCompRelDO;
import iih.bd.srv.emrterm.d.EmrEvent4TermDO;
import iih.bd.srv.emrterm.i.IEmretcomprelCudService;
import iih.bd.srv.emrterm.i.IEmretcomprelExtService;
import iih.bd.srv.emrterm.i.IEmretcomprelRService;
import iih.bd.srv.emrterm.i.IEmrevent4termCudService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

@Service(serviceInterfaces = { IEmretcomprelExtService.class }, binding = Binding.JSONRPC)
public class EmretcomprelExtServiceImpl implements IEmretcomprelExtService{

	/*
	 * 1.新增病历事件，同时保存新增的事件以及对应的事件组件关系
	 * 2.已存在事件下新增修改事件组件关系
	 */
	@Override
	public EmrEvent4TermDO[] Save(EmrEvent4TermDO emrEvent4TermDO, EmrEtCompRelDO[] emrEtCompRelDOs) throws BizException
	{
		IEmrevent4termCudService emrevent4termCudService=ServiceFinder.find(IEmrevent4termCudService.class);
		
		IEmretcomprelCudService emretcomprelCudService=ServiceFinder.find(IEmretcomprelCudService.class);

		//判断是否新增事件
		if(emrEvent4TermDO.getId_mraet() != null){
			
			//更新
			emrEvent4TermDO.setStatus(1);
		}
		else
		{
			//新增
			emrEvent4TermDO.setStatus(2);
		}

		//先保存该事件，获取返回值，确定Id_mraet
		EmrEvent4TermDO[] emrEvent4TermDOs = emrevent4termCudService.save(new EmrEvent4TermDO[] { emrEvent4TermDO });
		
		getEmrtermDOs(emrEtCompRelDOs, emrEvent4TermDOs[0]);
		
		emretcomprelCudService.save(emrEtCompRelDOs);
		
		return emrEvent4TermDOs;
	}
	
	/*
	 * 新增事件组件关系赋值
	 */
	private void getEmrtermDOs(EmrEtCompRelDO[] emrEtCompRelDOs, EmrEvent4TermDO emrEvent4TermDO)
	{
		
		if (emrEtCompRelDOs != null && emrEtCompRelDOs.length > 0) {

			for (EmrEtCompRelDO relDO : emrEtCompRelDOs) {
				
				//Update：1，New：2
				if(relDO.getStatus() == 2){
					
					relDO.setId_mraet(emrEvent4TermDO.getId_mraet());
				}
			}
		}
	}
	
	/*
	 * 删除事件时，删除对应的事件组件关系
	 */
	@Override
	public void Delete(EmrEvent4TermDO[] emrEvent4TermDOs) throws BizException
	{
		IEmrevent4termCudService emrevent4termCudService=ServiceFinder.find(IEmrevent4termCudService.class);
		
		IEmretcomprelCudService emretcomprelCudService=ServiceFinder.find(IEmretcomprelCudService.class);
		
		IEmretcomprelRService emretcomprelRService=ServiceFinder.find(IEmretcomprelRService.class);

		if (emrEvent4TermDOs != null && emrEvent4TermDOs.length > 0) {

			List<String> listIDS = new ArrayList<String>();

			for (EmrEvent4TermDO eventDO : emrEvent4TermDOs) {
				
				if (!listIDS.contains(eventDO.getId_mraet())) {

					listIDS.add(eventDO.getId_mraet());
				}
			}

			if (listIDS.size() > 0) {

				String whereStr = "";

				for (String id : listIDS) {

					whereStr += (whereStr.length() == 0 ? "" : ",") + "'" + id + "'";
				}

				if (!StringUtil.isEmpty(whereStr)) {

					EmrEtCompRelDO[] emrEtCompRelDOs = emretcomprelRService.find(" id_mraet in(" + whereStr + ")", "", FBoolean.FALSE);

					emretcomprelCudService.delete(emrEtCompRelDOs);
				}

			}

			emrevent4termCudService.delete(emrEvent4TermDOs);
		}
	}
}
