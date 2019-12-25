package io.alpha.core.type;

/**
 * 系统错误码
 * 允许继承，所以不用枚举了
 */
public class SystemCode {

    public static final SystemCode REQUIRE_AUTHENTICATION = new SystemCode(0, "鉴权失败！");
    public static final SystemCode SUCCESS = new SystemCode(200, "SUCCESS!");
    public static final SystemCode EMPTY_DATA = new SystemCode(201, "暂无数据！");
    public static final SystemCode UNKNOWN_ERROR = new SystemCode(202, "系统繁忙请稍后再试！");
    public static final SystemCode SYSTEM_ERROR = new SystemCode(500, "系统错误!");

    /**
     * 200（OK）- 如果现有资源已被更改
     201（created）- 如果新资源被创建
     202（accepted）- 已接受处理请求但尚未完成（异步处理）
     301（Moved Permanently）- 资源的URI被更新
     303（See Other）- 其他（如，负载均衡）
     400（bad request）- 指代坏请求
     404 （not found）- 资源不存在
     406 （not acceptable）- 服务端不支持所需表示
     409 （conflict）- 通用冲突
     412 （Precondition Failed）- 前置条件失败（如执行条件更新时的冲突）
     415 （unsupported media type）- 接受到的表示不受支持
     500 （internal server error）- 通用错误响应
     503 （Service Unavailable）- 服务当前无法处理请求
     */

    private Integer code;

    private String msg;

    public SystemCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
