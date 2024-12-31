package iih.bl.cc.s.bp;

import java.util.HashSet;

import org.apache.commons.lang.StringUtils;

import iih.bl.cc.blcc.d.BlCcDO;
import iih.bl.cc.blcc.i.IBlccMDORService;
import iih.bl.cc.blfi.d.BlFiDO;
import iih.bl.cc.blfi.i.IBlfiCudService;
import iih.bl.cc.blfi.i.IBlfiRService;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 小组长结账
 * @author HanJQ
 */
public class DoGRPLeaderCheckoutBP {

	/**
	 * 小组长结账
	 * @param blCcDos
	 * @param code_fi
	 * @return
	 * @throws BizException 
	 */
	public BlCcDO[] doGRPLeaderCheckout(BlFiDO fiDo ,BlCcDO[] blCcDos) throws BizException {
		//检验财务凭证号
		validateGRPLeaderCheckout(fiDo);
		IBlfiCudService BlfiCrudService = ServiceFinder.find(IBlfiCudService.class);
		fiDo.setStatus(DOStatus.NEW);
        BlFiDO[] fiDos = BlfiCrudService.save(new BlFiDO[] { fiDo });

        fiDo = fiDos[0];
        
        DAFacade daf = new DAFacade();
		daf.setAddTimeStamp(false);
        for (int i = 0, len = blCcDos.length; i < len; i++)
        {
        	blCcDos[i].setId_fi(fiDo.getId_fi());
        	blCcDos[i].setFg_fi(FBoolean.TRUE);
        	blCcDos[i].setDt_fi(fiDo.getDt_fi());
        	blCcDos[i].setStatus(DOStatus.UPDATED);
        	daf.updateDO(blCcDos[i], new String[] { BlCcDO.ID_FI, BlCcDO.FG_FI ,BlCcDO.DT_FI });
        }
		return blCcDos;
	}
	/**
	 * 检查财务凭证号和信息是否完全
	 * @param fiDo
	 * @author hanJQ 2019年3月1日
	 */
	private void validateGRPLeaderCheckout(BlFiDO fiDo) throws BizException{
		String BLCC0001 = BlParams.BLCC0001();
		if(!"0".equals(BLCC0001) && StringUtils.isBlank(fiDo.getFicode())){
			throw new BizException("当前医院不允许财务凭证号为空！");
		}
		IBlfiRService BlfiRService = ServiceFinder.find(IBlfiRService.class);
		if(!StringUtils.isBlank(fiDo.getFicode())){
			BlFiDO[] fiDos = BlfiRService.findByAttrValString(BlFiDO.FICODE, fiDo.getFicode());
			if(fiDos != null && fiDos.length > 0)
			throw new BizException("财务凭证号"+fiDo.getFicode()+"已使用！");
		}
	}
	/**
	 * 小组长取消结账
	 * @param fiDos
	 * @return
	 * @throws BizException 
	 */
	public BlFiDO[] doGRPLeaderCancelCheckout(BlFiDO[] fiDos) throws BizException {
		IBlfiCudService BlfiCrudService = ServiceFinder.find(IBlfiCudService.class);
        BlFiDO[] fiDos2 = BlfiCrudService.update(fiDos);
        HashSet<String> id_fis = new HashSet<>();
        for(BlFiDO fiDo : fiDos2){
        	id_fis.add(fiDo.getId_fi());
        }
//        IBlccMDOCudService _blccMDOCrudService = ServiceFinder.find(IBlccMDOCudService.class);
        IBlccMDORService _blccMDORService = ServiceFinder.find(IBlccMDORService.class);
        String[] idFis = id_fis.toArray(new String[id_fis.size()]);
        BlCcDO[] blCcDos = _blccMDORService.findByAttrValStrings(BlCcDO.ID_FI, idFis);
        
        DAFacade daf = new DAFacade();
		daf.setAddTimeStamp(false);
		
        for(BlCcDO ccDo : blCcDos){
        	ccDo.setDt_canc(fiDos2[0].getDt_fi_canc());
        	ccDo.setFg_fi(FBoolean.FALSE);
        	ccDo.setStatus(DOStatus.UPDATED);
        	daf.updateDO(ccDo, new String[] { BlCcDO.ID_FI, BlCcDO.FG_FI ,BlCcDO.DT_FI });
        }
		return fiDos2;
	}

}
