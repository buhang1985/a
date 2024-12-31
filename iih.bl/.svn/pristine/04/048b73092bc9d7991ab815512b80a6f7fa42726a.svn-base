package iih.bl.comm.ep;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.DoBuilder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 实体扩展基类
 * @author yankan
 * @since 2017-07-05
 *
 * @param <T>
 */
public class BaseEP<T extends BaseDO> {
	private Class<T> clazz;
	private BaseDO entity;
	private BaseDOService<T> entityService;
	/**
	 * 默认构造函数
	 */
	public BaseEP(){
		this.clazz = AppFwUtil.getGenericsActualClass(super.getClass());
		this.entity = DoBuilder.construct(this.clazz);
		entityService = new BaseDOService(this.entity.getDODesc());
	}
	/**
	 * 构造函数
	 * @param entity
	 */
	public BaseEP(T entity){
		this.clazz = AppFwUtil.getGenericsActualClass(super.getClass());
		this.entity = entity;		
		this.entityService = new BaseDOService(this.entity.getDODesc());
	}
	/**
	 * 根据ID获取DO对象
	 * @param id ID
	 * @return DO对象
	 * @throws BizException
	 */
	public T findById(String id) throws BizException{
		return entityService.findById(id);
	}
	/**
	 * 根据ID获取DO对象集合
	 * @param ids ID集合
	 * @return DO对象集合
	 * @throws BizException
	 */
	public T[] findByIds(String[] ids) throws BizException{
		return entityService.findByIds(ids, FBoolean.FALSE);
	}
	/**
	 * 根据ID获取DO对象集合
	 * @param ids ID集合
	 * @param isLasy 是否懒加载
	 * @return DO对象集合
	 * @throws BizException
	 */
	public T[] findByIds(String[] ids,FBoolean isLasy) throws BizException{
		return entityService.findByIds(ids, isLasy);
	}
	/**
	 * 根据属性值查询
	 * @param attr 属性
	 * @param value 属性值
	 * @return DO集合
	 * @throws BizException
	 */
	public T[] findByAttrValString(String attr, String value) throws BizException{
		return entityService.findByAttrValString(attr, value);
	}
	/**
	 * 
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public T[] findByAttrValStrings(String attr, String[] values) throws BizException{
		return entityService.findByAttrValStrings(attr, values);
	}
	/**
	 * 根据条件查询
	 * @param whereStr 条件SQL
	 * @param orderStr 排序字段
	 * @param isLazy 是否懒加载
	 * @return DO集合
	 * @throws BizException
	 */
	public T[] find(String whereStr, String orderStr, FBoolean isLazy) throws BizException{
		return entityService.find(whereStr, orderStr, isLazy);
	}
	/**
	 * 保存
	 * @param entity 实体DO
	 * @return DO对象
	 * @throws BizException
	 */
	public T save(T entity) throws BizException{
		entityService.save(entity);
		return entity;
	}
	/**
	 * 保存
	 * @param entities 实体集合
	 * @return DO集合
	 * @throws BizException
	 */
	public T[] save(T[] entities) throws BizException{
		return entityService.save(entities);
	}
	/**
	 * 根据ID删除
	 * @param id ID
	 * @throws BizException
	 */
	public void deleteById(String id) throws BizException{
		new DAFacade().deleteByPK(this.clazz, id);
	}
	/**
	 * 根据ID删除
	 * @param ids ID集合
	 * @throws BizException
	 */
	public void deleteByIds(String[] ids) throws BizException{
		new DAFacade().deleteByPKs(this.clazz, ids);
	}
	/**
	 * 根据条件删除
	 * @param wherestr
	 * @throws BizException
	 */
	public void deleteByWhere(String wherestr) throws BizException{
		new DAFacade().deleteByWhere(this.clazz, wherestr);
	}
	/**
	 * 删除DO对象
	 * @param entities DO对象集合
	 * @throws BizException
	 */
	public void delete(T[] entities) throws BizException{
		entityService.delete(entities);
	}
	/**
	 * 逻辑删除
	 * @param entities DO对象集合
	 * @throws BizException
	 */
	public void logicDelete(T[] entities) throws BizException{
		entityService.logicDelete(entities);
	}
}
