const base = {
    get() {
        return {
            url : "http://localhost:8080/springcloudqwoh94gn/",
            name: "springcloudqwoh94gn",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springcloudqwoh94gn/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于微服务架构的巡游出租管理平台"
        } 
    }
}
export default base
