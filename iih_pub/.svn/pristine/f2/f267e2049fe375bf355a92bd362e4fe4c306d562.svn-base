package iih.mi.itf2.facade;

import iih.bd.base.exception.ArgumentNullException;
import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.biz.dto.d.OepSettleRtnValDTO;
import iih.mi.itf2.bizflowitf.IBdFlowItf;
import iih.mi.itf2.bizflowitf.IOepFlowItf;
import iih.mi.itf2.dto.MiContext;
import iih.mi.itf2.dto.MiResultOutParam;
import iih.mi.itf2.dto.drugmanualcomp.d.LoadOrginalDataInParam;
import iih.mi.itf2.dto.drugmanualcomp.d.LoadOrginalDataOutParam;
import iih.mi.itf2.dto.mideldircontrast.d.MiDelDirContrastInParam;
import iih.mi.itf2.dto.mideldircontrast.d.MiDelDirContrastOutParam;
import iih.mi.itf2.dto.midirautocomp.d.MiDirAutoCompInParam;
import iih.mi.itf2.dto.midirautocomp.d.MiDirAutoCompOutParam;
import iih.mi.itf2.dto.midirsave.d.MiDirSaveInParam;
import iih.mi.itf2.dto.midirsave.d.MiDirSaveOutParam;
import iih.mi.itf2.dto.misavedircontrast.d.MiSaveDirContrastInParam;
import iih.mi.itf2.dto.misavedircontrast.d.MiSaveDirContrastOutParam;
import iih.mi.itf2.dto.refreshcomp.d.MiDirRefreshCompInParam;
import iih.mi.itf2.dto.refreshcomp.d.MiDirRefreshCompOutParam;
import iih.mi.itf2.factory.MiAbstractFactory;
import iih.mi.itf2.util.MiParamUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.utils.ObjectCreator;

/**
 * 医保平台业务接口门面类
 * @author ly
 *
 */
public class MiFacade {

	private MiContext miContext;
	private MiAbstractFactory factory;
	
	public MiFacade(MiContext miContext) throws BizException{
		
		this.miContext = miContext;
		if(this.miContext == null){
			throw new ArgumentNullException("MiContext");
		}
		if(StringUtil.isEmpty(this.miContext.getIdHp())){
			throw new ArgumentNullException("MiContext.IdHp");
		}
		
		String set = MiParamUtil.MI0001(this.miContext.getIdHp());
		if(StringUtil.isEmpty(set)){
			throw new ArgumentNullException("未配置工厂");
		}
		try {
			String[] classModules = set.split(",");
			String module = "";
			String className = classModules[0];
			if (classModules.length == 3) {
				module = classModules[2];
			}
			this.factory = (MiAbstractFactory) ObjectCreator.newInstance(module, className);
		} catch (Exception e) {
			throw new BizException("实例化工厂失败", e);
		}
	}
	
	/***************基础数据部分****************/
	
	/**
	 * 医保目录保存
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public MiResultOutParam<MiDirSaveOutParam> saveMiDir(MiDirSaveInParam param) throws BizException{
		IBdFlowItf itf = this.factory.createIBdFlowItfInstance(this.miContext);
		return itf.saveMiDir(param);
	}
	
	/**
	 * 医保目录自动对照
	 * @author zhang.hw
	 * @date 2019年6月2日
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public MiResultOutParam<MiDirAutoCompOutParam> autoCompMiDir(MiDirAutoCompInParam param) throws BizException{
		IBdFlowItf itf = this.factory.createIBdFlowItfInstance(this.miContext);
		return itf.autoCompMiDir(param);
	}
	
	/**
	 * 医保目录刷新对照
	 * @author zhang.hw
	 * @date 2019年6月2日
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public MiResultOutParam<MiDirRefreshCompOutParam> refreshCompMiDir(MiDirRefreshCompInParam param) throws BizException{
		IBdFlowItf itf = this.factory.createIBdFlowItfInstance(this.miContext);
		return itf.refreshCompMiDir(param);
	}
	
	/**
	 * 目录保存对照
	 * @author zhang.hw
	 * @date 2019年7月15日
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public MiResultOutParam<MiSaveDirContrastOutParam> miSaveDirContrast(MiSaveDirContrastInParam param) throws BizException{
		IBdFlowItf itf = this.factory.createIBdFlowItfInstance(this.miContext);
		return itf.miSaveDirContrast(param);
	}
	
	/**
	 * 目录删除对照
	 * @author zhang.hw
	 * @date 2019年7月15日
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public MiResultOutParam<MiDelDirContrastOutParam> miDelDirContrast(MiDelDirContrastInParam param) throws BizException{
		IBdFlowItf itf = this.factory.createIBdFlowItfInstance(this.miContext);
		return itf.miDelDirContrast(param);
	}
	
	/**
	 * 查询已对照的原始目录信息
	 * @author zhang.hw
	 * @date 2019年7月18日
	 * @param inParam
	 * @return
	 * @throws BizException
	 */
	public MiResultOutParam<LoadOrginalDataOutParam> selectOrginalData(LoadOrginalDataInParam inParam) throws BizException{
		IBdFlowItf itf = this.factory.createIBdFlowItfInstance(this.miContext);
		return itf.selectOrginalData(inParam);
	}
	
	/**
	 * 保存门诊医保分摊数据
	 * @param hisPropertyDTO
	 * @return
	 * @throws BizException
	 */
	public  FArrayList savePayPropDataOep(OepSettleRtnValDTO hpPayRtnValDto, HisPropertyRefHpDTO hisPropertyDTO)throws BizException{
		IOepFlowItf itf = this.factory.createIOepFlowItfInstance(this.miContext);
		return itf.savePayPropDataOep(hpPayRtnValDto,hisPropertyDTO);
	}
	
	/** 
	 * 存储医保分摊红冲数据门诊
	 * @param hisPropertyDTO
	 * @return
	 * @throws BizException
	 */
	public FArrayList saveBackPropDataOep(HisPropertyRefHpDTO hisPropertyDTO) throws BizException
	{
		IOepFlowItf itf = this.factory.createIOepFlowItfInstance(this.miContext);
		return itf.saveBackPropDataOep(hisPropertyDTO);
	}
}
