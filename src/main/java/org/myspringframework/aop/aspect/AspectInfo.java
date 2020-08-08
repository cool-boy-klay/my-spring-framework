package org.myspringframework.aop.aspect;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AspectInfo {
    private int order;
    private DefaultAspect defaultAspect;
}
