package com.gicws.day27.Service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")   // Correct for Q9
public class SingletonService { }