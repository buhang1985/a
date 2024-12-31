package iih.ei.std.d.v1.bd.comm.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface QueryNodeOper {

    @DmEnumDesc(name="等于",description="")
    public static final String EQUALS="01"; //等于
    @DmEnumDesc(name="不等于",description="")
    public static final String NOTEQUALS="02"; //不等于
    @DmEnumDesc(name="包含",description="")
    public static final String LIKE="03"; //包含
    @DmEnumDesc(name="左包含",description="")
    public static final String LEFTLIKE="04"; //左包含
    @DmEnumDesc(name="右包含",description="")
    public static final String RIGHTLIKE="05"; //右包含
    @DmEnumDesc(name="为空",description="")
    public static final String ISNULL="06"; //为空
    @DmEnumDesc(name="不为空",description="")
    public static final String ISNOTNULL="07"; //不为空
    @DmEnumDesc(name="忽略大小写等于",description="")
    public static final String EQUALSIC="08"; //忽略大小写等于
    @DmEnumDesc(name="忽略大小写不等于",description="")
    public static final String NOTEQUALSIC="09"; //忽略大小写不等于
    @DmEnumDesc(name="忽略大小写包含",description="")
    public static final String LIKEIC="10"; //忽略大小写包含
    @DmEnumDesc(name="忽略大小写左包含",description="")
    public static final String LEFTLIKEIC="11"; //忽略大小写左包含
    @DmEnumDesc(name="忽略大小写右包含",description="")
    public static final String RIGHTLIKEIC="12"; //忽略大小写右包含
}	
