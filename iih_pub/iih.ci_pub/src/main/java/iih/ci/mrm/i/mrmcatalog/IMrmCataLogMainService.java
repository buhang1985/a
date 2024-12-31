package iih.ci.mrm.i.mrmcatalog;

import iih.ci.mrm.dto.mrmcatalog.d.MrmCatalogCheckResultDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 病案编目主要服务
 * @author 张静波
 * @date 2018年8月31日 下午6:23:55
 */
public interface IMrmCataLogMainService {
	/**
	 * 从病案首页获取数据，保存到病案编目表内
	 * @return
	 */
	public abstract FBoolean saveMrmfpByMrfp(String id_ent)throws BizException;
	/**
	 * 重置编目，从病案首页获取数据，保存到病案编目表内
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public FBoolean reSetMrmfp(String id_ent) throws BizException;
	/**
	 * 核查当前编目数据的正误
	 * @param sqlFixWhere 固定的约束方式
	 * @return
	 */
	public abstract MrmCatalogCheckResultDTO[] checkCatalongData(String sqlFixWhere)throws BizException;
	/**
	 * 提交病案编目
	 * @param id_ent 就诊号
	 * @param id_cata_user 编目人
	 * @param id_cata_dep 编目科室
	 * @return
	 */
	public FBoolean cataLogSubmit(String id_ent,String id_cata_user,String id_cata_dep)throws BizException;
}
