package com.hms.entity;

import jakarta.persistence.GenerationType;

public @interface GeneratzedValue {
    GenerationType strategy();
}
