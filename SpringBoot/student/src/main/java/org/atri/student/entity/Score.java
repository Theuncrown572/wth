package org.atri.student.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@TableName("score")
public class Score {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String subjects;
    @TableField("time_start")
    private String timeStart;
    @TableField("time_end")
    private String timeEnd;
    private String number;
    private String grade;
    private String teacher;

}
