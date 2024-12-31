package iih.mi.itf2.bizflowitf;

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
import xap.mw.core.data.BizException;

/**
 * 基础数据流程医保接口
 * @author ly 2019/05/20
 *
 */
public interface IBdFlowItf {

	/**
	 * 医保目录保存
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract MiResultOutParam<MiDirSaveOutParam> saveMiDir(MiDirSaveInParam param) throws BizException;
	
	/**
	 * 医保目录自动对照
	 * @author zhang.hw
	 * @date 2019年6月2日
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract MiResultOutParam<MiDirAutoCompOutParam> autoCompMiDir(MiDirAutoCompInParam param) throws BizException;
	
	/**
	 * 医保目录刷新对照
	 * @author zhang.hw
	 * @date 2019年6月2日
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract MiResultOutParam<MiDirRefreshCompOutParam> refreshCompMiDir(MiDirRefreshCompInParam param) throws BizException;
	
	/**
	 * 目录保存对照
	 * @author zhang.hw
	 * @date 2019年7月15日
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract MiResultOutParam<MiSaveDirContrastOutParam> miSaveDirContrast(MiSaveDirContrastInParam param) throws BizException;
	
	/**
	 * 目录删除对照
	 * @author zhang.hw
	 * @date 2019年7月15日
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract MiResultOutParam<MiDelDirContrastOutParam> miDelDirContrast(MiDelDirContrastInParam param) throws BizException;
	
	/**
	 * 查询已对照的原始目录信息
	 * @author zhang.hw
	 * @date 2019年7月18日
	 * @param inParam
	 * @return
	 * @throws BizException
	 */
	public abstract MiResultOutParam<LoadOrginalDataOutParam> selectOrginalData(LoadOrginalDataInParam inParam) throws BizException;
	
}
