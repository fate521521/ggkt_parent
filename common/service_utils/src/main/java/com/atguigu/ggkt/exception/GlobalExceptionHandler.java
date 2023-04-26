package com.atguigu.ggkt.exception;

import com.atguigu.ggkt.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 *  第一种 全局异常处理
 *      方法步骤-----> 1、创建异常处理类
 *                    2、在异常处理类添加注解，使用aop @ControllerAdvice
 *                    3、异常处理类编写具体针对异常处理方法，方法上面添加注解@ExceptionHandler
 *  第二种 特定异常处理
 *        先去找特定的异常，没有再去找全局异常
 *  第三种 自定义异常处理
 *  ---------> 1、创建自定义异常类，继承RuntimeException
 *              2、在自定义异常类创建属性
 *              3、在全局异常处理类添加自定义异常处理的方法
 *              4、手动抛出自定义异常
 */
@ControllerAdvice  //aop 面向切面编程，不改变源代码情况下，增强功能
public class GlobalExceptionHandler {

    //全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody //让他返回json数据
    public Result error(Exception e) {
        System.out.println("全局.....");
        e.printStackTrace();
        return Result.fail(null).message("执行全局异常处理");
    }

    //特定异常处理ArithmeticException
    //ArithmeticException 当出现异常算术条件时抛出。例如：整数除以零---->会抛出此类的一个实例
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e) {
        System.out.println("特定.....");
        e.printStackTrace();
        return Result.fail(null).message("执行ArithmeticException异常处理");
    }

    //自定义异常处理GgktException
    @ExceptionHandler(GgktException.class)
    @ResponseBody
    public Result error(GgktException e) {
        e.printStackTrace();
        return Result.fail(null).code(e.getCode()).message(e.getMsg());
    }


//    @ControllerAdvice是Spring MVC中的一个注解，用于定义全局控制器（Controller）通知，主要用于处理MVC控制器层面的异常和数据绑定问题等。

//    @ControllerAdvice的作用相当于一个拦截器，可以在所有标有@Controller或@RestController类的方法中统一添加额外的处理逻辑，例如全局异常处理、全局数据绑定、全局数据预处理等，减少冗余代码和代码复杂度，并提高代码可读性和可维护性。

//    在Spring MVC中，@ControllerAdvice注解需要配合@ExceptionHandler、@InitBinder和@ModelAttribute等注解使用，分别用于定义异常处理方法、数据绑定方法和预处理方法。下面是一个@ControllerAdvice类的示例代码：

//    @ControllerAdvice
//    public class GlobalExceptionHandler {
//
//        @ExceptionHandler(value = Exception.class)
//        public ModelAndView handleException(HttpServletRequest request, Exception e) throws Exception {
//            ModelAndView mav = new ModelAndView();
//            mav.addObject("exception", e);
//            mav.addObject("url", request.getRequestURL());
//            mav.setViewName("error");
//            return mav;
//        }
//    }
}
