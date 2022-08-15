/*회원등록을 할 때 필요한 요소에 대한 유효성 검사를 하는 코드이다 2022-08-15
* 나중에는 자바스크립트를 이용한 View에서 직접 유효성검사를 하는 코드로 수정해야겠다.*/

package com.spring.study.error;

import com.spring.study.domain.RegisterDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class RegisterRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterDTO.class.isAssignableFrom(clazz);
    }

    /*필요한 요소들이 모두 입력되었는지 확인한다
    * 비밀번호와 비밀번호 확인이 동일한지 확인한다
    * [추가예정] - 아이디 닉네임 중복여부*/
    @Override
    public void validate(Object target, Errors errors) {
        RegisterDTO registerDTO = (RegisterDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required");
        if(!registerDTO.getPassword().isEmpty() && !registerDTO.getConfirmPassword().isEmpty()){
            if(!registerDTO.isEqualPasswordConfirmPassword()){
                errors.rejectValue("confirmPassword", "nomatch");
            }
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickname", "required");
    }
}
