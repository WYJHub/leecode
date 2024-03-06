// //核酸检测人员 通知
// //单位通知
// //无单位人员 由社区人员通知
// package test;

// import java.sql.Time;
// import java.util.ArrayList;
// import java.util.Random;
// import java.util.Scanner;

// class User {
//     private String userId;
//     private String areaId;
//     private String type;
//     public String getUserId() {
//         return userId;
//     }
//     public void setUserId(String userId) {
//         this.userId = userId;
//     }
//     public String getAreaId() {
//         return areaId;
//     }
//     public void setAreaId(String areaId) {
//         this.areaId = areaId;
//     }
//     public String getType() {
//         return type;
//     }
//     public void setType(String type) {
//         this.type = type;
//     }

    
// }



// // 定义请求类
// class ReinspectionNoticeRequest {
//     private User user;

//     private Time time;
//     public ReinspectionNoticeRequest(User user, Time time) {
//         this.user = user;
//         this.time = time;
//     }

//     public Time getTime() {
//         return time;
//     }

//     public User getUser() {
//         return user;
//     }
// }

// class UserService {
//     public boolean checkUserArea(String areaId) {
//         ArrayList<String> list = new ArrayList<>();
//         //模拟从数据库中查数据
//         list.add("111");
//         list.add("222");
       
//         for(String area : list) {
//             //该用户所在区域为高风险
//             if(areaId.equals(area)) {
//                 return true;
//             }
//         }
//         return false;
//     }

//     public boolean getHomeTime(String UserId) {
//         return new Random().nextInt(21) < 14;
//     }
// }


// // 定义响应类
// class Response {
//     private boolean success;
//     private String message;

//     public Response(boolean success, String message) {
//         this.success = success;
//         this.message = message;
//     }

//     public boolean isSuccess() {
//         return success;
//     }

//     public String getMessage() {
//         return message;
//     }
// }

// // 定义抽象处理器类
// abstract class RequestHandler {
//     protected RequestHandler nextHandler;

//     public void setNext(RequestHandler handler) {
//         this.nextHandler = handler;
//     }

//     public abstract void handleRequest(ReinspectionNoticeRequest request);
// }

// // 创建具体处理器类

// //检查该人员是否有单位，有单位且该人员对应核酸检测之后未由Unit发起通知，则由该处理器发起通知
// class UnitHandler extends RequestHandler {
//     public void handleRequest(ReinspectionNoticeRequest request) {
//         if (userService.checkUserUnit(request.getUser().getUserId()) && !unitUserNoticeService.findNoticeByUserIdAndTime(request.getUser().getUserId(), request.getTime())) {
//             //符合条件，发起通知
//             unitUserNoticeService.sendReinspectionNotice(request.getUser());
//             // 处理完毕，结束处理流程
//             return;
//         }

//         // 传递请求给下一个处理器
//         if (nextHandler != null) {
//             nextHandler.handleRequest(request);
//         }
//     }
// }

// class CDCHandler extends RequestHandler {
//     public void handleRequest(ReinspectionNoticeRequest request) {
//         if (!cdcUserNoticeService.findNoticeByUserIdAndTime(request.getUser().getUserId(), request.getTime())) {
//             // 符合条件，发起通知
//             cdcUserNoticeService.sendReinspectionNotice(request.getUser());
//             // 处理完毕，结束处理流程
//             return;
//         }

//         // 传递请求给下一个处理器
//         if (nextHandler != null) {
//             nextHandler.handleRequest(request);
//         }
//     }
// }


// class AcidInfoDao {
//     public int getAcidCount(String userId) {
//         return new Random().nextInt(21);
//     }
// }

// class AcidInfoService {
//     public boolean checkAcidCount(String userId, String type) {
//         if(type.equals("次密接") && (new AcidInfoDao().getAcidCount(userId) < 3)) {
//             return true;
//         }
//         else if(type.equals("密接") && (new AcidInfoDao().getAcidCount(userId) < 6)) {
//             return true;
//         }
//         return false;
//     }
// }


// //检查用户核酸次数是否符合要求
// class CheckAcidCountTestHandler extends RequestHandler {
//     public void handleRequest(Request request) {
//         if (request.getType().equals("red") && new AcidInfoService().checkAcidCount(request.getUser().getUserId(), request.getUser().getType())) {
//             // 核酸次数不满足要求
//             System.out.println("不满足红码核酸检测要求...");
//             Response response = new Response(true, "核酸次数未到达申诉条件");
//             // 处理完毕，结束处理流程
//             return;
//         }

//         // 传递请求给下一个处理器
//         if (nextHandler != null) {
//             nextHandler.handleRequest(request);
//         }
//     }
// }

// //检测居家时间
// class CheckHomeTimeHandler extends RequestHandler {
//     public void handleRequest(Request request) {
//         if (request.getType().equals("red") && new UserService().getHomeTime(request.getUser().getUserId())) {
//             // 居家未满规定日期
//             System.out.println("居家未满十四天...");
//             // 返回修改结果
//             Response response = new Response(true, "Modification processed successfully");
//             // 处理完毕，结束处理流程
//             return;
//         }

//         // 传递请求给下一个处理器
//         if (nextHandler != null) {
//             nextHandler.handleRequest(request);
//         }
//     }
// }

// //超级管理员/社区管理员
// class SuperManangerHandler extends RequestHandler {
//     public void handleRequest(Request request) {
//         if (request.getType().equals("red") || request.getType().equals("yellow")) {
            
//             System.out.println("成功发起申诉，等待管理员审核...");
//             System.out.println("调用HealthAppealService,向数据库添加一条记录");
//             // HealAppealService HealAppealService.addAppeal();
        
//             // 返回修改结果
//             Response response = new Response(true, "胜诉审核中...");
//             // 处理完毕，结束处理流程
//             return;
//         }

//         // 传递请求给下一个处理器
//         if (nextHandler != null) {
//             nextHandler.handleRequest(request);
//         }
//     }
// }

// // 使用示例
// public class Main {
//     public static void main(String[] args) {
//         // 构建责任链
//         UnitHandler unitHandler = new UnitHandler();
//         CommunityHandler communityHandler = new CommunityHandler();
//         CDCHandler cdcHandler = new CDCHandler();

//         unitHandler.setNext(communityHandler);
//         communityHandler.setNext(cdcHandler);



//         unitHandler.handleRequest(request);
//     }
// }