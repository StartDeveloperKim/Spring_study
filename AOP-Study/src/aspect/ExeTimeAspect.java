package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExeTimeAspect {
	
	@Pointcut("execution(public * chapter7..*(..))") // 공통 기능을 적용할 대상을 설정한다.
	private void publicTarget() {
	}
	
	@Around("publicTarget()") // Around Advice를 설정
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		// ProceedingJoinPoint는 프록시 대상 객체의 메서드를 호출할 때 사용한다.
		long start = System.nanoTime(); // 시작 시간 측정
		try {
			Object result = joinPoint.proceed(); // 실제 대상 객체의 메서드를 호출
			return result; // 결과 반환
		} finally {
			long finish = System.nanoTime(); // 끝나는 시간 측정
			Signature sig = joinPoint.getSignature();
			System.out.printf("%s.%s(%s) 실행 시간 : %d ns\n",
					joinPoint.getTarget().getClass().getSimpleName(),
					sig.getName(), Arrays.toString(joinPoint.getArgs()),
					(finish - start));
		}
		
	}
}
