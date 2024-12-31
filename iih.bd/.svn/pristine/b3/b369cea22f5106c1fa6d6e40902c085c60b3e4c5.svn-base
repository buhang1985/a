package iih.bd.srv.emrterm.s;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.emrterm.d.EmrTermDO;
import iih.bd.srv.emrterm.d.EmrTermGrpDO;
import iih.bd.srv.emrterm.d.EmrtermcaAggDO;
import iih.bd.srv.emrterm.i.IEmrTermGrpDOCudService;
import iih.bd.srv.emrterm.i.IEmrtermCudService;
import iih.bd.srv.emrterm.i.IEmrtermRService;
import iih.bd.srv.emrterm.i.IEmrtermcaCudService;
import iih.bd.srv.emrterm.i.IEmrtermgrpExtService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.xbd.udi.d.UdidocDO;

@Service(serviceInterfaces = { IEmrtermgrpExtService.class }, binding = Binding.JSONRPC)
public class IEmrtermgrpExtServiceImpl implements IEmrtermgrpExtService {
	
	/*
	 * 1.病历术语新增分组（分组下新增术语），同时保存新增的分组以及下属的术语
	 * 2.在已存在分组下新增修改术语
	 */
	@Override
	public void Save(EmrTermGrpDO emrTermGrpDO, EmrTermDO[] emrTermDOs) throws BizException {

		IEmrTermGrpDOCudService emrTermGrpSaveService = ServiceFinder.find(IEmrTermGrpDOCudService.class);

		IEmrtermCudService emrtermSaveService = ServiceFinder.find(IEmrtermCudService.class);
        
		//判断是否新增分组
		if(emrTermGrpDO.getId_mratermgrp()!=null){
			
			//更新
			emrTermGrpDO.setStatus(1);
		}
		else
		{
			//新增
			emrTermGrpDO.setStatus(2);
		}

		//先保存该分组，获取返回值，确定Id_mratermgrp
		EmrTermGrpDO[] emrTermGrpDOs = emrTermGrpSaveService.save(new EmrTermGrpDO[] { emrTermGrpDO });
		
		getEmrtermDOs(emrTermDOs, emrTermGrpDOs[0]);
		
		emrtermSaveService.save(emrTermDOs);
	}
	
	/*
	 * 新增术语赋值
	 */
	private void getEmrtermDOs(EmrTermDO[] emrTermDOs, EmrTermGrpDO emrTermGrpDO)
	{
		
		if (emrTermDOs != null && emrTermDOs.length > 0) {

			for (EmrTermDO tremDO : emrTermDOs) {
				
				//Update：1，New：2
				if(tremDO.getStatus() == 2){
					
					tremDO.setId_mratermgrp(emrTermGrpDO.getId_mratermgrp());
					
					tremDO.setId_mrtermsys(emrTermGrpDO.getId_mrtermsys());
					
					tremDO.setSd_mrtermsys(emrTermGrpDO.getSd_mrtermsys());
					
					tremDO.setMr_sys_name(emrTermGrpDO.getMr_sys_name());
					
					if(emrTermGrpDO.getId_mratermca()!=null)
						tremDO.setId_mratermca(emrTermGrpDO.getId_mratermca());
				}
			}
		}
	}

	/*
	 * 引用保存分类
	 */
	@Override
	public void SaveRef(EmrtermcaAggDO[] emrtermcaAggDOs, UdidocDO udidocDO) throws BizException {
		
		IEmrtermcaCudService emrTermCaSaveService = ServiceFinder.find(IEmrtermcaCudService.class);
		
		IEmrtermCudService emrtermSaveService = ServiceFinder.find(IEmrtermCudService.class);
		
		IEmrtermRService emrtermQueryService=ServiceFinder.find(IEmrtermRService.class);
		
		if(emrtermcaAggDOs != null && emrtermcaAggDOs.length>0)
		{
			List<EmrtermcaAggDO> listAggDOs = new ArrayList<EmrtermcaAggDO>();
			
			//为每个引用的术语分类分配主键caID
			String[] mratermca_Ids = new DBUtil().getOIDs(emrtermcaAggDOs.length);
			
			for(int i=0; i < emrtermcaAggDOs.length; i++)
			{
				
				//分配新的AggDO
				EmrtermcaAggDO caAggDONew = new EmrtermcaAggDO();
				
				caAggDONew = emrtermcaAggDOs[i];
				
				//为caDO设置新的主键caID,适用范围
				caAggDONew.getParentDO().setId_mratermca(mratermca_Ids[i]);
				
				caAggDONew.getParentDO().setName(caAggDONew.getParentDO().getName()+"("+caAggDONew.getParentDO().getMr_scopetp_name()+")");
				
				caAggDONew.getParentDO().setId_scopetp(udidocDO.getId_udidoc());
				
				caAggDONew.getParentDO().setSd_scopetp(udidocDO.getCode());
				
				caAggDONew.getParentDO().setMr_scopetp_name(udidocDO.getName());
				
				caAggDONew.getParentDO().setStatus(2);
				
				//获取新的GrpDOs
				EmrTermGrpDO[] emrTermGrpDOs = caAggDONew.getEmrTermGrpDO();
				
				if(emrTermGrpDOs != null && emrTermGrpDOs.length > 0)
				{
					//为每个术语分组分配主键grpID
					String[] mratermgrp_Ids = new DBUtil().getOIDs(emrTermGrpDOs.length);
					
					for(int j = 0; j < emrTermGrpDOs.length; j++)
					{
						//分组grpDO的主键grpID还没有改变，获取该分组下所有的术语DOs
						EmrTermDO[] emrTermDOs = emrtermQueryService.find(" id_mratermgrp ='" + emrTermGrpDOs[j].getId_mratermgrp() + "'", "", FBoolean.FALSE);
						
						//为grpDO设置新的主键grpID，caID
						emrTermGrpDOs[j].setId_mratermgrp(mratermgrp_Ids[j]);
						
						emrTermGrpDOs[j].setId_mratermca(mratermca_Ids[i]);
						
						emrTermGrpDOs[j].setStatus(2);
						
						if(emrTermDOs != null && emrTermDOs.length > 0)
						{
							List<EmrTermDO> listEmrTermDOs= new ArrayList<EmrTermDO>();
							
							for(EmrTermDO emrTermDO : emrTermDOs)
							{
								//分配新的术语DO
								EmrTermDO emrTermDONew = new EmrTermDO();
								
								emrTermDONew = emrTermDO;
								
								//为每个新的术语设置主键ID，grpID,caID
								emrTermDONew.setId_mraterm(null);
								
								emrTermDONew.setId_mratermgrp(mratermgrp_Ids[j]);
								
								emrTermDONew.setId_mratermca(mratermca_Ids[i]);
								
								emrTermDONew.setStatus(2);
								
								listEmrTermDOs.add(emrTermDONew);
							}
							
							//保存新的术语DOs
							EmrTermDO[] newEmrTermDOs=(EmrTermDO[])listEmrTermDOs.toArray(new EmrTermDO[listEmrTermDOs.size()]);
							emrtermSaveService.save(newEmrTermDOs);
						}

					}
					
				}
				
				listAggDOs.add(caAggDONew);
			}
			
			//保存引用的术语分类AggDOs
			EmrtermcaAggDO[] newEmrtermcaAggDOs=(EmrtermcaAggDO[])listAggDOs.toArray(new EmrtermcaAggDO[listAggDOs.size()]);
			emrTermCaSaveService.save(newEmrtermcaAggDOs);
		}
	}
	
	
	/*
	 * 删除分类和分组时，删除对应的术语
	 */
	@Override
	public void Delete(EmrTermGrpDO[] emrTermGrpDOs) throws BizException {

		IEmrTermGrpDOCudService emrTermGrpSaveService = ServiceFinder.find(IEmrTermGrpDOCudService.class);
		
		IEmrtermCudService emrtermSaveService = ServiceFinder.find(IEmrtermCudService.class);
		
		IEmrtermRService emrtermQueryService = ServiceFinder.find(IEmrtermRService.class);

		if (emrTermGrpDOs != null && emrTermGrpDOs.length > 0) {

			List<String> listIDS = new ArrayList<String>();

			for (EmrTermGrpDO grpDO : emrTermGrpDOs) {
				
				if (!listIDS.contains(grpDO.getId_mratermgrp())) {

					listIDS.add(grpDO.getId_mratermgrp());
				}
			}

			if (listIDS.size() > 0) {

				String whereStr = "";

				for (String id : listIDS) {

					whereStr += (whereStr.length() == 0 ? "" : ",") + "'" + id + "'";
				}

				if (!StringUtil.isEmpty(whereStr)) {

					EmrTermDO[] grpTermDOs = emrtermQueryService.find(" id_mratermgrp in(" + whereStr + ")", "", FBoolean.FALSE);

					emrtermSaveService.delete(grpTermDOs);
				}

			}

			emrTermGrpSaveService.delete(emrTermGrpDOs);
		}
	}
}
