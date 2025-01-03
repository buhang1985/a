package iih.ci.mr.mrsurdataclassi.s;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mr.mrsurdataclassi.d.MrSurDataClassiDO;
import iih.ci.mr.mrsurdataclassi.i.IMrsurdataclassiCudService;
import iih.ci.mr.mrsurdataclassi.i.IMrsurdataclassiExtService;
import iih.ci.mr.mrsurdataclassi.i.IMrsurdataclassiRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

@Service(serviceInterfaces = {IMrsurdataclassiExtService.class}, binding = Binding.JSONRPC)
public class MrsurdataclassiExtServiceImpl implements IMrsurdataclassiExtService{

	@Override
	public MrSurDataClassiDO[] createSurgicalClassification(String id_ent, String name, String code, FDateTime time)
			throws BizException {
		MrSurDataClassiDO SurDataClassiDo=new MrSurDataClassiDO();
		SurDataClassiDo.setId_ent(id_ent);
		SurDataClassiDo.setId_mrcactm(ICiMrDictCodeConst.ID_MRCACTM_SHOUSHU);
		SurDataClassiDo.setCode_operation(code);
		SurDataClassiDo.setName_operation(name);
		SurDataClassiDo.setTime_operation(time);
		SurDataClassiDo.setStatus(DOStatus.NEW);
		IMrsurdataclassiCudService service=ServiceFinder.find(IMrsurdataclassiCudService.class);
		MrSurDataClassiDO[] mrSurDataClassiDOs = service.save(new MrSurDataClassiDO[]{SurDataClassiDo});
		return mrSurDataClassiDOs;
	}

	@Override
	public void deleteSurgicalClassification(String id_ent, String name, String code, FDateTime time)
			throws BizException {
		IMrsurdataclassiRService rService=ServiceFinder.find(IMrsurdataclassiRService.class);
		IMrsurdataclassiCudService cudService=ServiceFinder.find(IMrsurdataclassiCudService.class);
		String condition="id_ent='"+id_ent+"' and name_operation='"+name+"' and code_operation='"+code+"'";
		if(time!=null){
			condition +=" and time_operation='"+time.toString()+"'";
		}
		MrSurDataClassiDO[] mrSurDataClassiDOs = rService.find(condition, "sv", FBoolean.FALSE);
		if(mrSurDataClassiDOs!=null && mrSurDataClassiDOs.length>0){
			ICiemrRService mrService =ServiceFinder.find(ICiemrRService.class);
			for(MrSurDataClassiDO data: mrSurDataClassiDOs){
				CiMrDO[] ciMrDOs = mrService.find("id_surdata_classi='"+data.getId_surdata_classi()+"'", "sv", FBoolean.FALSE);
				if(ciMrDOs==null || ciMrDOs.length<1){
					cudService.delete(new MrSurDataClassiDO[]{data});
				}
			}
		}
	}
}
