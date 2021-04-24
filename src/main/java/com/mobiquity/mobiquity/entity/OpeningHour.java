package com.mobiquity.mobiquity.entity;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpeningHour {
    public int dayOfWeek;
    public List<Hour> hours;
}
