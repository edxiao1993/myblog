package org.kevin.demo0212.model.june8_2024;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Kevin.Zng
 * @date 2024/6/8 19:15
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JuneSubscriber {
    private String msisdn;

    private String custid;

    private String region;

    private String iccid;
}
