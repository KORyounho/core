package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // 컴포넌트(@Component)라고 되어져있는것들을 전부다 스캔하는 어노테이션
                // 컴포넌트 스캔을 사용하면, 의존관계주입읠 기존 AppConfig.class에서 하던것과는 달리, AutoWired를 통해서 자동으로 의존성 주입 진행함.

        basePackages = "hello.core.member",
        //basicPackages를 사용하면, 원하는 패키지의 시작 위치를 지정함. 해당 패키지 아래에 있는 것들만 스프링 컨테이너에 빈으로 등록 가능함.
        basePackageClasses = AutoAppConfig.class,
                // 위의 basicPackages를 설정 안하기 위해서, 어차피 ComponentScan을 해당 패키지 아래의 하위 패키지만 스캔하기에, 설정 정보인
                // AppConfig나 AutoAppConfig를 스프링 컨테이너에 등록시키고 싶은 패키지의 가장 상단에 놓으면 된다.
                // 예를 들어, hello.core,  hello.core.service,  hello.core.repository가 있으면, AppConfig를 hello.core에 넣으면
                // service와 repository를 둘다 스캔한다/
                //basicPackages를 사용하면, 원하는 패키지의 시작 위치를 지정함. 해당 패키지 아래에 있는 것들만 스프링 컨테이너에 빈으로 등록 가능함.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 뺄것을 지정하는 것.
                                                                                     //Configuration을 제외시키는 이유 -> AppConfig에서 이미
                                                                                      // 수동으로 설정 다 해놨는데
                                                                                    //충돌 방지 및, Configuration 자체에 이미 @Component가 있음
)
public class AutoAppConfig {
}
// 컴포넌트 스캔을 지정할때 권장하는 것 -> basePackage등의 설정을 따로 안하고, excludeFilters를 이용해서 몇가