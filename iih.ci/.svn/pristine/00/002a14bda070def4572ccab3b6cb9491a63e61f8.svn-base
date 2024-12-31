package iih.ci.sdk.database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.ymer.core.util.IOUtil;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 数据库优化查询参数
 * 
 * @author wangqingzhu
 *
 */
public class SqlParamBuilder extends SqlParam {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StringBuilder sqlBuilder = new StringBuilder();
	
	private static final String IN_TEMP_TABLE = "TEMP_SQLPARAMBUILDER_ID";

	public SqlParamBuilder() {
		init();
	}

	public SqlParamBuilder(String sql) {
		this.sqlBuilder.append(sql);
		init();
	}

	public SqlParamBuilder(String sql, SqlParam p) {
		this.sqlBuilder.append(sql);
		this.addParam(p);
		init();
	}
	
	private void init() {
		// 初始化临时表 kv 结构
		try {
			
			if(!new DAFacade().isTableExisted(IN_TEMP_TABLE)) {
				new DAFacade().execUpdate("create global temporary table temp_sqlparambuilder_id (valueid varchar(50), keyid varchar(50)) on commit delete rows");
			}
			
		} catch (DAException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getSql() {
		return sqlBuilder.toString();
	}

	public SqlParamBuilder setSql(String s) {
		sqlBuilder = new StringBuilder(s);

		return this;
	}

	public SqlParam getParam() {
		return this;
	}

	/**
	 * 从模块资源文件中加载sql内容
	 * @param sqlFile  , 如："iih/ci/ems/order/sql/服务物化图.sql"
	 * @return
	 * @throws BizException
	 */
	public SqlParamBuilder parseSqlFile(Class<?> cls, String fileName) throws BizException {
		try {
			
			InputStream stream = null;
			try {
				stream = cls.getResourceAsStream(fileName);
				
				return this.appendSql(IOUtil.readStringFromStream(stream));
			} finally {
				IOUtils.closeQuietly(stream);
			}
		} catch (IOException e) {
			throw new BizException(e);
		}
	}

	/**
	 * 追加sql语句
	 * 
	 * @param s
	 * @return
	 */
	public SqlParamBuilder appendSql(String s) {
		if (null == s || s.length() == 0)
			return this;
		this.sqlBuilder.append(" " + s + " ");
		return this;
	}

	public SqlParamBuilder appendSql(String[] sz, String splchar) {
		for (String str : sz) {
			this.appendSql(str);
			if (null != splchar) {
				this.appendSql(splchar);
			}
		}

		if (null != splchar) {
			int nPos = this.sqlBuilder.lastIndexOf(splchar);
			this.sqlBuilder.deleteCharAt(nPos);
		}

		return this;
	}

	/**
	 * 增加参数
	 * 
	 * @param v
	 * @return
	 */
	public SqlParamBuilder appendParam(Object v) {

		this.addParam(v);

		return this;
	}

	public SqlParamBuilder appendParam(SqlParam p) {
		if (p != null) {
			this.getParameters().addAll(p.getParameters());
		}
		return this;
	}

	public SqlParamBuilder appendParam(List<?> p) {
		if (p != null) {
			this.getParameters().addAll(p);
		}
		return this;
	}

	/**
	 * sql 条件拼接 in 集合
	 * 
	 * @param where
	 * @param szValue
	 * @return
	 */
	@Deprecated
	public SqlParamBuilder sqlInParam(String where, Object[] szValue) {

		return this.appendSql(where).in("", szValue, false);

	}

	/**
	 * 以 and 方式结束字符串的拼接
	 * 
	 * @param feild
	 *            字段值
	 * @param szValue
	 *            集合值
	 * @return
	 */
	@Deprecated
	public SqlParamBuilder andSqlInParam(String feild, Object[] szValue) {

		return this.andIn(feild, szValue);
	}

	/**
	 * in 集合处理
	 * 
	 * @param feild
	 * @param p
	 * @return
	 */
	@Deprecated
	public SqlParamBuilder andSqlInParam(String feild, SqlParamBuilder p) {

		return this.and().in(feild,p);

	}

	/**
	 * 组建 in 集合sql条件语句
	 * 
	 * @param feild
	 * @param p
	 * @return
	 */
	public SqlParamBuilder in(String feild, SqlParamBuilder p) {

		
		return appendSql(String.format(" %s in (%s) ", (null == feild || feild.length() == 0 ? "" : feild), p.getSql()))
				.appendParam(p);

	}

	/**
	 * 组建 in 集合sql条件语句
	 * 
	 * @param feild
	 * @param p
	 * @return
	 */
	public SqlParamBuilder in(SqlParamBuilder p) {

		return in("", p);

	}

	/**
	 * where 条件的字段 in 集合操作
	 * 
	 * @param feild
	 *            字段
	 * @param szValue
	 *            集合值
	 * @return
	 */
	public SqlParamBuilder whereIn(String fd, Object[] szValue) {

		return this.where().in(fd, szValue, false);
	}

	/**
	 * where 条件的字段 in 集合操作
	 * 
	 * @param feild
	 * @param szValue
	 * @return
	 */
	public SqlParamBuilder whereIn(String fd, Collection<?> c) {

		return this.where().in(fd, c, false);
	}

	/**
	 * where 条件的字段 in 集合操作
	 * 
	 * @param feild
	 * @param p
	 * @return
	 */
	public SqlParamBuilder whereIn(String feild, SqlParamBuilder p) {
		return this.where().in(feild, p);
	}

	/**
	 * 替换标记字符串
	 * 
	 * @param tagStr
	 *            标记
	 * @param feild
	 *            字段名称
	 * @param szValue
	 *            字符串集合
	 * @return
	 */
	public SqlParamBuilder replace(String tagStr, String fd, String[] szValue, boolean not) {

		return this.replace(tagStr, new SqlParamBuilder().in(fd, szValue, not));
	}

	public SqlParamBuilder replace(String tagStr, String fd, Collection<?> c, boolean not) {

		return this.replace(tagStr, new SqlParamBuilder().in(fd, c, not));
	}

	/**
	 * 替换指定标记 tagStr 为 "XXX = ?", 并且增加参数 v
	 * 
	 * @param tagStr
	 *            标记
	 * @param c
	 *            字段
	 * @param v
	 * @return
	 */
	public SqlParamBuilder replace(String tagStr, String c, String v, boolean not) {
		return this.replace(tagStr, new SqlParamBuilder().equals(c, v, not));
	}

	public SqlParamBuilder replace(String tagStr, SqlParamBuilder p) {
		// 获取tagStr所在sql字符串中的位置，该位置将作为查找sql中？字符的截止索引位置
		int nEndIndex = sqlBuilder.indexOf(tagStr);

		// 定义 ？ 查找结果计数器，最多
		int xTagCount = -1;
		for (int index = 0; index < nEndIndex; ++index) {
			if (sqlBuilder.charAt(index) == '?') {
				xTagCount++;
			}
		}
		// 将参数中的sql字符串替换到tagStr所标记的位置
		sqlBuilder = new StringBuilder(sqlBuilder.toString().replace(tagStr, p.getSql()));

		// 如果sql字符串中并没有找到一个?，变量绑定标记，则将需要替换的SqlParamBuilder对象中的绑定变量对象插入到当前变量对象的队头
		if (0 == xTagCount) {
			// 重新创建一个临时的sql构造器
			SqlParamBuilder tmp = new SqlParamBuilder();
			tmp.appendParam(p).appendParam(this);
			this.clearParams();
			this.appendParam(tmp);
		}

		// 当前sqlparam构造器中只是一个纯sql字符串，并参数绑定集合对象中为空（话句话说就是sql中并没有 ? 变量绑定占位符）
		if (-1 == xTagCount) {
			return this;
		}
		// 如果sql中的变量绑定占位符与当前的变量个数数量一致，则将参数中的SqlParamBuilder对象中的变量追加的当前变量集合的队尾
		else if (xTagCount == this.getCountParams()) {
			this.appendParam(p);
		}
		// 处理需要将参数SqlParamBuilder对象中的变量集合插入到当前的正确位置，根据？的位置将SqlParamBuilder参数中的变量集合插入到当前参数集合的正确位置
		else {
			List<?> preList = this.getParameters().subList(0, xTagCount - 1);
			List<?> sufList = this.getParameters().subList(xTagCount, this.getParameters().size() - 1);
			// 清空当前的变量存储集合
			this.clearParams();
			// 将参数中的变量集合数据插入到xTagCount的当前变量集合对象的位置
			this.appendParam(preList).appendParam(p).appendParam(sufList);
		}
		return this;
	}

	/**
	 * 简单追加sql以及绑定参数实体对象
	 * 
	 * @param c
	 * @param v
	 * @return
	 */
	public SqlParamBuilder appendSqlParam(String c, Object v) {
		return appendSql(c).appendParam(v);
	}

	/**
	 * 简单追加sql以及绑定参数实体对象
	 * 
	 * @param p
	 * @return
	 */
	public SqlParamBuilder appendSqlParamBuilder(SqlParamBuilder p) {
		if (null == p || p.isEmpty())
			return this;
		return appendSql(p.getSql()).appendParam(p);
	}

	/**
	 * 等于 and 条件sql语句
	 * 
	 * @param fd
	 * @param v
	 * @return
	 */
	@Deprecated
	public SqlParamBuilder andSqlParam(String fd, Object v) {

		return this.and().equals(fd, v, false);
	}

	/**
	 * 大于
	 * 
	 * @param fd
	 * @param v
	 * @return
	 */
	public SqlParamBuilder andGreaterThan(String fd, Object v) {
		return this.and().greaterThan(fd, v);
	}

	/**
	 * 字段 > 值
	 * 
	 * @param fd
	 * @param v
	 * @return
	 */
	public SqlParamBuilder greaterThan(String fd, Object v) {
		return this.appendSql(String.format(" %s > ? ", fd)).appendParam(v);
	}

	/**
	 * 大于等于
	 * 
	 * @param fd
	 * @param v
	 * @return
	 */
	public SqlParamBuilder andGreaterEqualThan(String fd, Object v) {
		return this.and().greaterEqualThan(fd, v);
	}

	/**
	 * 字段 >= 值
	 * 
	 * @param fd
	 * @param v
	 * @return
	 */
	public SqlParamBuilder greaterEqualThan(String fd, Object v) {
		return this.appendSql(String.format(" %s >= ? ", fd)).appendParam(v);
	}

	/**
	 * 小于
	 * 
	 * @param fd
	 * @param v
	 * @return
	 */
	public SqlParamBuilder andLessThan(String fd, Object v) {
		return this.and().appendSql(String.format(" %s < ? ", fd)).appendParam(v);
	}

	/**
	 * 小于等于
	 * 
	 * @param fd
	 * @param v
	 * @return
	 */
	public SqlParamBuilder andLessEqualThan(String fd, Object v) {
		return this.and().appendSql(String.format(" %s <= ? ", fd)).appendParam(v);
	}

	public SqlParamBuilder union(boolean all) {
		return this.appendSql(String.format(" union %s ", all ? "all" : ""));
	}

	public SqlParamBuilder union(SqlParamBuilder p) {

		return this.union(false).appendSqlParamBuilder(p);
	}

	public SqlParamBuilder union(SqlParamBuilder p, String u) {

		return this.union(p).appendSql(u);
	}

	public SqlParamBuilder unionAll(SqlParamBuilder p) {

		return this.union(true).appendSqlParamBuilder(p);
	}

	public SqlParamBuilder lBrackets() {
		return this.appendSql(" (");
	}

	public SqlParamBuilder rBrackets() {
		return this.appendSql(") ");
	}

	public SqlParamBuilder brackets(String sql) {
		return lBrackets().appendSql(sql).rBrackets();
	}

	public SqlParamBuilder brackets(SqlParamBuilder p) {
		return lBrackets().appendSqlParamBuilder(p).rBrackets();
	}

	public SqlParamBuilder distinct() {

		return this.appendSql(" Distinct ");
	}

	public SqlParamBuilder distinct(String s) {
		return this.distinct().appendSql(s);
	}

	public SqlParamBuilder select() {

		return this.appendSql(" Select ");
	}

	public SqlParamBuilder select(String s) {

		return this.select().appendSql(s);
	}

	public SqlParamBuilder select(String[] ss) {

		String flds = "";
		for (String s : ss) {
			flds += ", " + s;
		}
		return select().appendSql(flds.substring(1));

	}

	public SqlParamBuilder from() {

		return this.appendSql(" from ");
	}

	public SqlParamBuilder from(String sql) {
		return this.from().appendSql(sql);
	}

	/**
	 * 拼接from子句
	 * 
	 * @param p
	 * @return
	 */
	public SqlParamBuilder from(SqlParamBuilder p) {

		return this.from().appendSqlParamBuilder(p);
	}

	/**
	 * 拼接表名
	 * 
	 * @param tb
	 * @return
	 */
	public SqlParamBuilder table(String tb) {
		return this.appendSql(tb);
	}

	/**
	 * 拼接别名
	 * 
	 * @param als
	 * @return
	 */
	public SqlParamBuilder alias(String als) {
		return this.appendSql(als);
	}

	public SqlParamBuilder where() {

		return this.appendSql(" where ");
	}

	public SqlParamBuilder where(SqlParamBuilder p) {

		return this.where().appendSqlParamBuilder(p);
	}

	public SqlParamBuilder where(String w) {

		return this.where().appendSql(w);
	}

	public SqlParamBuilder where(String fd, Object v) {

		return this.where().equals(fd, v, false);
	}

	/**
	 * 字段 = 值 语句
	 * 
	 * @param fd
	 * @param v
	 * @param not
	 * @return
	 */
	public SqlParamBuilder equals(String fd, Object v, boolean not) {
		if (null == v)
			return this;
		return this.appendSql(fd).appendSql(String.format(" %s= ? ", not ? "!" : "")).appendParam(v);
	}

	/**
	 * or 关键字条件
	 * 
	 * @return
	 */
	public SqlParamBuilder or() {
		return this.appendSql(" or ");
	}

	/**
	 * or 条件
	 * 
	 * @param p
	 * @return
	 */
	public SqlParamBuilder or(SqlParamBuilder p) {
		return this.or().appendSqlParamBuilder(p);
	}

	/**
	 * or 字段 = 值 条件
	 * 
	 * @param fd
	 * @param v
	 * @return
	 */
	public SqlParamBuilder or(String fd, Object v) {
		return this.or().equals(fd, v, false);
	}

	/**
	 * or 字段 ！= 值 条件
	 * 
	 * @param fd
	 * @param v
	 * @return
	 */
	public SqlParamBuilder orNot(String fd, Object v) {
		return this.or().equals(fd, v, true);
	}

	/**
	 * 
	 * @param fd
	 * @param szValue
	 * @return
	 */
	public SqlParamBuilder orIn(String fd, Object[] szValue) {

		return this.or().in(fd, szValue, false);
	}

	public SqlParamBuilder orIn(String fd, Collection<?> c) {

		return this.or().in(fd, c, false);
	}

	public SqlParamBuilder orNotIn(String fd, Object[] szValue) {

		return this.or().in(fd, szValue, true);
	}

	public SqlParamBuilder orNotIn(String fd, Collection<?> c) {

		return this.or().in(fd, c, true);
	}

	/**
	 * or 字段 is null 条件
	 * 
	 * @param fd
	 * @return
	 */
	public SqlParamBuilder orNull(String fd) {

		return this.or().isNull(fd);
	}

	/**
	 * 字段 is null
	 * 
	 * @param fd
	 * @return
	 */
	public SqlParamBuilder isNull(String fd) {
		return this.appendSql(fd).appendSql(" is null ");
	}

	/**
	 * or 字段 is null 条件
	 * 
	 * @param fd
	 * @return
	 */
	public SqlParamBuilder orNotNull(String fd) {

		return this.or().isNotNull(fd);
	}

	/**
	 * 字段 is not null
	 * 
	 * @param fd
	 * @return
	 */
	public SqlParamBuilder isNotNull(String fd) {

		return this.appendSql(fd).appendSql(" is not null ");
	}

	/**
	 * in 字段 [not] in (集合)
	 * 
	 * @param fd
	 * @param szValue
	 * @param not
	 * @return
	 */
	public SqlParamBuilder in(String fd, Object[] szValue, boolean not) {
		// 
		if(szValue != null && szValue.length > 999) {
			// 1、建立临时表
			
			
			return null;
		}
		else {
		String conditions = "";
		for (Object v : szValue) {
			conditions += ",?";
			this.addParam(v);
		}

		return this.appendSql(String.format(" %s %s in (%s) ", (null == fd || fd.length() == 0 ? "" : fd),
				not ? "not" : "", conditions.substring(1)));
		}
	}

	/**
	 * in 子查询集合条件
	 * 
	 * @param fd
	 * @param p
	 * @param not
	 * @return
	 */
	public SqlParamBuilder in(String fd, SqlParamBuilder p, boolean not) {
		if (null == p || p.isEmpty())
			return this;
		return this.appendSql(String.format(" %s %s in (%s) ", (null == fd || fd.length() == 0 ? "" : fd),
				not ? "not" : "", p.getSql())).appendParam(p);

	}

	/**
	 * in 字段 [not] in (集合)
	 * 
	 * @param fd
	 * @param c
	 * @param not
	 * @return
	 */
	public SqlParamBuilder in(String fd, Collection<?> c, boolean not) {
		if (null == c || c.size() == 0)
			return this;
		return this.in(fd, c.toArray(), not);
	}

	/**
	 * not in 集合条件
	 * 
	 * @param fd
	 * @param szValue
	 * @return
	 */
	public SqlParamBuilder notIn(String fd, Object[] szValue) {

		return this.in(fd, szValue, true);
	}

	/**
	 * and 关键字条件
	 * 
	 * @return
	 */
	public SqlParamBuilder and() {
		return this.appendSql(" and ");
	}

	public SqlParamBuilder and(SqlParamBuilder p) {

		return this.and().appendSqlParamBuilder(p);
	}

	public SqlParamBuilder and(String fd, Object v) {

		return this.and().equals(fd, v, false);

	}

	public SqlParamBuilder and(String fd, Object v, boolean not) {

		return this.and().equals(fd, v, not);

	}

	public SqlParamBuilder andNot(String fd, Object v) {
		return this.and().equals(fd, v, true);

	}

	public SqlParamBuilder andIn(String fd, Object[] szValue) {
		if (null == szValue || szValue.length == 0 || null == fd || fd.length() == 0)
			return this;
		return this.and().in(fd, szValue, false);
	}

	public SqlParamBuilder andIn(String fd, Object[] szValue, boolean not) {
		return this.and().in(fd, szValue, not);
	}

	public SqlParamBuilder andIn(String fd, Collection<?> c) {
		if (null == c || c.size() == 0 || null == fd || fd.length() == 0)
			return this;
		return this.and().in(fd, c, false);
	}

	public SqlParamBuilder andIn(String fd, Collection<?> c, boolean not) {
		if (null == c || c.size() == 0 || null == fd || fd.length() == 0)
			return this;
		return this.and().in(fd, c, not);
	}

	public SqlParamBuilder andIn(String fd, SqlParamBuilder p) {
		return this.and().in(fd, p, false);
	}

	public SqlParamBuilder andIn(String fd, SqlParamBuilder p, boolean not) {
		return this.and().in(fd, p, not);
	}

	public SqlParamBuilder andNotIn(String fd, Object[] szValue) {
		if (szValue == null || szValue.length == 0 || null == fd || fd.length() == 0) {
			return this;
		}
		return this.and().in(fd, szValue, true);
	}

	public SqlParamBuilder andNotIn(String fd, Collection<?> c) {
		if (null == c || c.size() == 0 || null == fd || fd.length() == 0)
			return this;
		return this.and().in(fd, c, true);
	}

	public SqlParamBuilder andNotIn(String fd, SqlParamBuilder p) {
		if (null == p || p.isEmpty() || null == fd || fd.length() == 0)
			return this;
		return this.and().in(fd, p, true);
	}

	public SqlParamBuilder leftJoin() {
		return this.appendSql(" left join ");
	}

	public SqlParamBuilder leftJoin(SqlParamBuilder p) {
		if (null == p || p.isEmpty())
			return this;
		return this.leftJoin().appendSql(p.getSql()).appendParam(p);
	}

	public SqlParamBuilder leftJoin(String sql) {

		return this.leftJoin().appendSql(sql);
	}

	public SqlParamBuilder leftJoin(String tb, String onStr) {
		return this.leftJoin().appendSql(tb).on(onStr);
	}

	public SqlParamBuilder leftJoin(String sql, Object v) {
		return leftJoin(sql).appendParam(v);
	}

	public SqlParamBuilder rightJoin() {
		return this.appendSql(" Right join ");
	}

	public SqlParamBuilder rightJoin(String sql) {
		if (null == sql || sql.length() == 0)
			return this;
		return this.rightJoin().appendSql(sql);
	}

	public SqlParamBuilder rightJoin(String sql, Object v) {
		if (null == sql || sql.length() == 0 || null == v)
			return this;
		return rightJoin(sql).appendParam(v);
	}

	public SqlParamBuilder innerJoin() {
		return this.appendSql(" Inner join ");
	}

	public SqlParamBuilder innerJoin(String sql) {

		return this.innerJoin().appendSql(sql);
	}

	public SqlParamBuilder innerJoin(String tb, String onStr) {

		return this.innerJoin().appendSql(tb).on().appendSql(onStr);
	}

	public SqlParamBuilder innerJoin(String sql, Object v) {

		this.addParam(v);
		return this.innerJoin(sql);
	}

	public SqlParamBuilder on() {
		return this.appendSql(" on ");
	}

	/**
	 * 链接条件
	 * 
	 * @param sql
	 * @return
	 */
	public SqlParamBuilder on(String sql) {

		return this.on().appendSql(sql);
	}

	public SqlParamBuilder orderBy() {
		return this.appendSql(" order by ");
	}

	public SqlParamBuilder orderBy(String[][] orderbys) {
		this.orderBy();
		for (String[] items : orderbys) {
			this.appendSql(
					String.format(" %s %s,", items[0], (items.length < 2 || items[1] == null) ? " asc " : items[1]));
		}
		return this;
	}

	public SqlParamBuilder groupBy() {
		return this.appendSql(" group by ");
	}

	public SqlParamBuilder groupBy(String[] fds) {
		return this.groupBy().appendSql(fds, ",");
	}

	/**
	 * 空值处理函数
	 * 
	 * @param sql
	 * @param def
	 * @return
	 */
	public SqlParamBuilder nvl(String sql, Object def) {

		return this.appendSql(String.format(" nvl(%s,%s) ", sql, def));
	}

	public boolean isEmpty() {
		return this.sqlBuilder.length() == 0;
	}

	public SqlParamBuilder clear() {
		sqlBuilder = new StringBuilder("");
		this.clearParams();
		return this;
	}

	/**
	 * 查询数据集合
	 * 
	 * @param p
	 * @param t
	 * @return
	 * @throws BizException
	 */
	public <T> List<T> Q(Class<?> c) throws BizException {
		return SqlParamDbUtils.Q(this, c);
	}

	/**
	 * 单列多行查询
	 * 
	 * @param p
	 * @param field
	 * @return
	 * @throws BizException
	 */
	public <T> List<T> Vs(String field) throws BizException {
		return SqlParamDbUtils.Vs(this, field);
	}

	/**
	 * 单值查询
	 * 
	 * @param p
	 * @param field
	 * @return
	 * @throws BizException
	 */
	public <T> T V(String field) throws BizException {
		return SqlParamDbUtils.V(this, field);
	}

	/**
	 * 单值查询集合
	 * 
	 * @param p
	 * @param field
	 * @return
	 * @throws BizException
	 */
	public <T> List<T> Q(String field) throws BizException {
		return SqlParamDbUtils.Q(this, field);
	}

	/**
	 * 宽松结果集查询
	 * 
	 * @param p
	 * @return
	 * @throws BizException
	 */
	public ListMapRecordSet Q() throws BizException {
		return SqlParamDbUtils.Q(this);
	}

	public MapRecordSet Qm() throws BizException {
		return SqlParamDbUtils.Qm(this);
	}

	/**
	 * 删除符合条件的数据
	 * 
	 * @throws DAException
	 */
	public void D() throws DAException {
		new DAFacade().execUpdate(this.getSql(), this);
	}

	@Override
	public String toString() {
		StringBuffer outputString = new StringBuffer(this.sqlBuilder.toString());
		int index = 0;

		int pos = 0;
		while ((pos = outputString.indexOf("?", pos)) > 0) {
			outputString = outputString.delete(pos, pos + 1);
			Object objValue = this.getParam().get(index++);
			outputString = outputString.insert(pos, String.format("'%s'", objValue));
		}

		return outputString.toString();
	}

}
