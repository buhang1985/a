package iih.ci.mrm.i.healthsystem;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;

/**
 * 数据抽取服务（根据数据转换节点维护的信息执行查询，返回不同格式的数据）
 * @author YanSu
 */
public interface IHealthSystemCrudService {
	/**
	 * 1.根据表转换id查询表和字段信息，，拼接查询SQL；
	 * 2.根据就诊主键查询数据并通过对照信息进行转换
	 * @param id_doc_comparison 表转换主键
	 * @param id_ents 就诊主键
	 * @return 以id_ent为Key进行分类封装的KV格式数据
	 * @throws BizException
	 */
	public abstract Map<String, List<Map<String, Object>>> getChangeDataWithMap(String id_doc_comparison, String[] id_ents, String idEntForm) throws BizException;
	/**
	 * 1.根据表转换id查询表和字段信息，拼接查询SQL；
	 * 2.根据就诊主键查询数据并通过对照信息进行转换
	 * @param fullClassName DO的全路径名
	 * @param id_extractdata 数据转换任务主键
	 * @param id_ents 就诊主键
	 * @return DO/DTO格式的obj数据
	 * @throws BizException
	 */
	public abstract List<Object> getChangeDataWithDO(String fullClassName, String id_doc_comparison, String[] id_ents, String idEntForm) throws BizException;
	/**
	 * 1.根据表转换id查询表和字段信息，，拼接查询SQL；
	 * 2.根据就诊主键查询数据并通过对照信息进行转换
	 * 3.数据查询语句需要是单表查询
	 * @param id_doc_comparison 表转换主键
	 * @param id_ents 就诊主键
	 * @return 以id_ent为Key进行分类封装的KV格式数据
	 * @throws BizException
	 */
	public abstract Map<String, List<Map<String, Object>>> getMapWithSigleForm(BaseDO obj,String id_doc_comparison, String[] id_ents,String idEntForm) throws BizException;
	/**
	 * 1.根据表转换id查询表和字段信息，拼接查询SQL；
	 * 2.根据就诊主键查询数据并通过对照信息进行转换
	 * 3.数据查询语句需要是单表查询
	 * @param fullClassName DO的全路径名
	 * @param id_extractdata 数据转换任务主键
	 * @param id_ents 就诊主键
	 * @return DO/DTO格式的obj数据
	 * @throws BizException
	 */
	public abstract List<Object> getArrayListWithSigleForm(BaseDO obj, String id_doc_comparison, String[] id_ents,String idEntForm)throws BizException;
	
}
