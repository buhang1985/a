package iih.ci.sdk.cache;

import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.permfw.pub.EnvContextUtil;

public class BDFreqInfoCache {

	public static String BDFreqInfoCache_Key = "BDFreqInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";
	private static String SQL_FREQ = "select FREQ.Id_freq,FREQ.Sd_frequnitct,UDI.Name Fre_name,FREQ.Frequnitct,FREQ.Code,FREQ.Name,FREQ.Freqct,FREQ.Fg_long,FREQ.Fg_long_edit,FREQ.Code_disp from bd_freq FREQ left join bd_udidoc UDI on UDI.Id_udidoc=FREQ.Id_frequnitct ";
	private static BDFreqInfoCache ins = new BDFreqInfoCache();

	private BDFreqInfoCache() {

	}

	private FreqDefDO[] gets(String code_entp) throws BizException {

		String sql = String.format(SQL_FREQ + "where FREQ.ds<1 and FREQ.fg_active='Y' and %s %s",
				EnvContextUtil.processEnvContext("", new FreqDefDO(), "FREQ"),
				IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp) ? " and FREQ.fg_use_op='Y' "
						: (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp) ? " and FREQ.fg_use_ip='Y' "
								: (IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(code_entp) ? " and FREQ.fg_use_er='Y' "
										: (IBdFcDictCodeConst.SD_CODE_ENTP_FA.equals(code_entp)
												? " and FREQ.fg_use_fm='Y' "
												: (IBdFcDictCodeConst.SD_CODE_ENTP_PE.equals(code_entp)
														? " and FREQ.fg_use_pe='Y' "
														: (IBdFcDictCodeConst.SD_CODE_ENTP_ES.equals(code_entp)
																? " and FREQ.FG_INTERVAL='Y' " : ""))))));

		@SuppressWarnings("unchecked")
		List<FreqDefDO> rst = (List<FreqDefDO>) new DAFacade().execQuery(sql, new BeanListHandler(FreqDefDO.class));
		return null != rst ? rst.toArray(new FreqDefDO[rst.size()]) : null;
	}

	private FreqDefDO get(String id_freq) throws BizException {
		String sql = String.format(SQL_FREQ + "where FREQ.ds<1 and FREQ.fg_active='Y' and %s and FREQ.id_freq ='%s'",
				EnvContextUtil.processEnvContext("", new FreqDefDO(), "FREQ"), id_freq);
		@SuppressWarnings("unchecked")
		List<FreqDefDO> szFreqInfo = (List<FreqDefDO>) new DAFacade().execQuery(sql,
				new BeanListHandler(FreqDefDO.class));
		if (null != szFreqInfo && szFreqInfo.size() > 0) {
			return szFreqInfo.get(0);
		}
		return null;
	}

	/**
	 * 获取频次集合对象
	 * 
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	public static FreqDefDO[] GetBdFreqInfos(CiEnContextDTO ctx) throws BizException {
		// 首先，从缓存获取数据
		FreqDefDO[] szFreqDefInfo = ContextCache.Get(BDFreqInfoCache.class.getSimpleName(), ctx.getId_grp(),
				ctx.getId_org(), BDFreqInfoCache_Key, ctx.getCode_entp());
		if (null == szFreqDefInfo || szFreqDefInfo.length == 0) {
			// 缓存没有数据，则进行数据库查询，并放置到缓存中
			szFreqDefInfo = ins.gets(ctx.getCode_entp());
			ContextCache.Put(BDFreqInfoCache.class.getSimpleName(), ctx.getId_grp(), ctx.getId_org(),
					BDFreqInfoCache_Key, ctx.getCode_entp(), szFreqDefInfo);
		}
		// 返回结果
		return szFreqDefInfo;
	}

	public static FreqDefDO GetFreqInfo(String id_freq) throws BizException {
		FreqDefDO freqInfo = ContextCache.Get(BDFreqInfoCache.class.getSimpleName(), DefaultContext_ID,
				DefaultContext_ID, BDFreqInfoCache_Key, id_freq);
		if (null == freqInfo) {
			freqInfo = ins.get(id_freq);
			if (null != freqInfo) {
				ContextCache.Put(BDFreqInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
						BDFreqInfoCache_Key, id_freq, freqInfo);
			}
		}
		return freqInfo;
	}

	/**
	 * 获取频次次数id
	 * 
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	public static String GetIdFrequnitctOfFreqInfo(String id_freq) throws BizException {

		FreqDefDO freqInfo = ContextCache.Get(BDFreqInfoCache.class.getSimpleName(), DefaultContext_ID,
				DefaultContext_ID, BDFreqInfoCache_Key, id_freq);
		if (null == freqInfo) {
			freqInfo = ins.get(id_freq);
			if (null != freqInfo) {
				ContextCache.Put(BDFreqInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
						BDFreqInfoCache_Key, id_freq, freqInfo);
			}
		}
		return freqInfo == null ? null : freqInfo.getId_frequnitct();
	}

	/**
	 * 获取频次名称
	 * 
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	public static String GetNameOfFreqInfo(String id_freq) throws BizException {

		FreqDefDO freqInfo = ContextCache.Get(BDFreqInfoCache.class.getSimpleName(), DefaultContext_ID,
				DefaultContext_ID, BDFreqInfoCache_Key, id_freq);
		if (null == freqInfo) {
			freqInfo = ins.get(id_freq);
			if (null != freqInfo) {
				ContextCache.Put(BDFreqInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
						BDFreqInfoCache_Key, id_freq, freqInfo);
			}
		}
		return freqInfo == null ? null : freqInfo.getName();
	}
	
	/**
	 * 获取频次名称显示编码
	 * 
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	public static String GetCodeDispOfFreqInfo(String id_freq) throws BizException {
		
		FreqDefDO freqInfo = ContextCache.Get(BDFreqInfoCache.class.getSimpleName(), DefaultContext_ID,
				DefaultContext_ID, BDFreqInfoCache_Key, id_freq);
		if (null == freqInfo) {
			freqInfo = ins.get(id_freq);
			if (null != freqInfo) {
				ContextCache.Put(BDFreqInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
						BDFreqInfoCache_Key, id_freq, freqInfo);
			}
		}
		return freqInfo == null ? null : freqInfo.getCode_disp();
	}

	/**
	 * 获取频次编码
	 * 
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	public static String GetFreCodeOfFreqInfo(String id_freq) throws BizException {

		FreqDefDO freqInfo = ContextCache.Get(BDFreqInfoCache.class.getSimpleName(), DefaultContext_ID,
				DefaultContext_ID, BDFreqInfoCache_Key, id_freq);
		if (null == freqInfo) {
			freqInfo = ins.get(id_freq);
			if (null != freqInfo) {
				ContextCache.Put(BDFreqInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
						BDFreqInfoCache_Key, id_freq, freqInfo);
			}
		}
		return freqInfo == null ? null : freqInfo.getCode();
	}

	/**
	 * 获取频次代码次数
	 * 
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	public static int GetFreqctOfFreqInfo(String id_freq) throws BizException {

		FreqDefDO freqInfo = ContextCache.Get(BDFreqInfoCache.class.getSimpleName(), DefaultContext_ID,
				DefaultContext_ID, BDFreqInfoCache_Key, id_freq);
		if (null == freqInfo) {
			freqInfo = ins.get(id_freq);
			if (null != freqInfo) {
				ContextCache.Put(BDFreqInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
						BDFreqInfoCache_Key, id_freq, freqInfo);
			}
		}
		return freqInfo == null ? -1 : freqInfo.getFreqct();
	}

	/**
	 * 获取频次SD值
	 * 
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	public static String GetSDFrequnitctOfFreqInfo(String id_freq) throws BizException {

		FreqDefDO freqInfo = ContextCache.Get(BDFreqInfoCache.class.getSimpleName(), DefaultContext_ID,
				DefaultContext_ID, BDFreqInfoCache_Key, id_freq);
		if (null == freqInfo) {
			freqInfo = ins.get(id_freq);
			if (null != freqInfo) {
				ContextCache.Put(BDFreqInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
						BDFreqInfoCache_Key, id_freq, freqInfo);
			}
		}
		return freqInfo == null ? null : freqInfo.getSd_frequnitct();
	}

	/**
	 * 获取长临标志
	 * 
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	public static FBoolean GetFgLongOfFreqInfo(String id_freq) throws BizException {

		FreqDefDO freqInfo = ContextCache.Get(BDFreqInfoCache.class.getSimpleName(), DefaultContext_ID,
				DefaultContext_ID, BDFreqInfoCache_Key, id_freq);
		if (null == freqInfo) {
			freqInfo = ins.get(id_freq);
			if (null != freqInfo) {
				ContextCache.Put(BDFreqInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
						BDFreqInfoCache_Key, id_freq, freqInfo);
			}
		}
		return freqInfo == null ? null : freqInfo.getFg_long();
	}

	/**
	 * 获取长临标志是否可以编辑
	 * 
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	public static FBoolean GetFgLongEditOfFreqInfo(String id_freq) throws BizException {

		FreqDefDO freqInfo = ContextCache.Get(BDFreqInfoCache.class.getSimpleName(), DefaultContext_ID,
				DefaultContext_ID, BDFreqInfoCache_Key, id_freq);
		if (null == freqInfo) {
			freqInfo = ins.get(id_freq);
			if (null != freqInfo) {
				ContextCache.Put(BDFreqInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID,
						BDFreqInfoCache_Key, id_freq, freqInfo);
			}
		}
		return freqInfo == null ? null : freqInfo.getFg_long_edit();
	}

	/**
	 * 清空频次缓存
	 */
	public static void Clear() {
		ContextCache.Clear(BDFreqInfoCache.class.getSimpleName());
	}
}
