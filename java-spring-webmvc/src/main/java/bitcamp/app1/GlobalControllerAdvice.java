package bitcamp.app1;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

// @ControllerAdvice
// => 이름에 이미 역할에 대한 정보가 담겨있다.
// => 페이지 컨트롤러를 실행할 때 충고하는 역할을 수행한다.
//    즉 프론트 컨트롤러가 페이지 컨트롤러의 request handler를 호출하기 전에
//    이 애노테이션이 붙은 클래스를 참고하여 적절한 메서드를 호출한다. 
@ControllerAdvice
public class GlobalControllerAdvice {

  @InitBinder
  public void initBinder(WebDataBinder binder) {

    DatePropertyEditor propEditor = new DatePropertyEditor();

    // WebDataBinder에 등록하기
    binder.registerCustomEditor(
        java.util.Date.class, // String을 Date 타입으로 바꾸는 에디터임을 지정한다. 
        propEditor  // 바꿔주는 일을 하는 프로퍼티 에디터를 등록한다.
        );
    
    // WebDataBinder에 등록하기
    binder.registerCustomEditor(
        Car.class, 
        new CarPropertyEditor()  // 바꿔주는 일을 하는 프로퍼티 에디터를 등록한다.
        );
    

    // WebDataBinder에 등록하기
    binder.registerCustomEditor(
        Engine.class, 
        new EnginePropertyEditor()  // 바꿔주는 일을 하는 프로퍼티 에디터를 등록한다.
        );

  }

  class DatePropertyEditor extends  PropertyEditorSupport {

    // yyyy-MM-dd 형태의 문자열을 java.util.Date 객체로 만들어주는 클래스를 준비한다.
    SimpleDateFormat format;

    public DatePropertyEditor() {
      // 프로퍼티 에디터를 사용하는 측에서 어떤 형식의 문자열을 Date 객체로 만들 것인지 
      // 설정하지 않았다면 기본으로 yyyy-MM-dd 형식의 문자열을 Date 객체로 만들도록 준비한다.
      format = new SimpleDateFormat("yyyy-MM-dd");
    }

    public DatePropertyEditor(SimpleDateFormat format) {
      // 물론 프로퍼티 에디터를 사용하는 측에서 날짜에 대한 문자열 형식을 지정할 수도 있다.
      this.format = format;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      System.out.println("DatePropertyEditor.setAsText()");
      // 프로퍼티 에디터를 사용하는 측(예: 프론트 컨트롤러)에서 
      // 문자열을 Date 객체로 바꾸기 위해 이 메서드를 호출할 것이다.
      // 그러면 이 메서드에서 문자열을 프로퍼티가 원하는 타입으로 변환한 후 저장하면 된다.
      try {
        Date date = format.parse(text); // String ===> java.util.Date 
        setValue(date); // 내부에 저장
      } catch (ParseException e) {
        throw new IllegalArgumentException(e);
      }
    }
  }

  class CarPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

      String[] strs = text.split(",");

      Car car = new Car();
      car.setModel(strs[0]);
      car.setCapacity(Integer.parseInt(strs[1]));
      car.setAuto(Boolean.parseBoolean(strs[2]));
      car.setCreatedDate(java.sql.Date.valueOf(strs[3]));

      setValue(car); // 내부에 저장

    }
  }
  
  class EnginePropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

      String[] strs = text.split(",");

      Engine engine = new Engine();
      engine.setModel(strs[0]);
      engine.setCc(Integer.parseInt(strs[1]));
      engine.setValve(Integer.parseInt(strs[2]));

      setValue(engine); // 내부에 저장

    }
  }
  
}
