package com.ysh.demo;

import com.ysh.demo.dto.Post;
import com.ysh.demo.handler.Chain;
import com.ysh.demo.handler.impl.ObjectNullValidator;
import com.ysh.demo.handler.impl.StringEmptyValidator;
import com.ysh.demo.handler.impl.ZeroGreaterThanValidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class DemoApplicationTests {
    Chain validator;

    @Before
    public void init() {
        System.out.println("-- test init --");
        Chain objectValid = new ObjectNullValidator();
        Chain StringValid = new StringEmptyValidator();
        Chain zeroValid = new ZeroGreaterThanValidator();

        validator = objectValid;
        validator.setNextChain(StringValid)
                .setNextChain(zeroValid);

    }

    @Test
    public void 정상_실패_통과() {
        //given : 정상 데이터
        Post post = new Post();
        post.setSeq(1L);
        post.setTitle("good data");
        post.setCreator("ysh");

        //when : 시퀀스/타이틀 벨리데이트
        boolean seqCheck = validator.validate(post.getSeq());
        boolean titleCheck = validator.validate(post.getTitle());

        //then : 정상 패스
        assertFalse(seqCheck);
        assertFalse(titleCheck);

        //given : 시퀀스 널
        post.setSeq(null);
        //when : 시퀀스 벨리데이트
        seqCheck = validator.validate(post.getSeq());
        //then : ObjectNullValidator 에서 검증
        assertTrue(seqCheck);

        //given : 시퀀스 0
        post.setSeq(0L);
        //when : 시퀀스 벨리데이트
        seqCheck = validator.validate(post.getSeq());
        //then : ZeroGraterThanValidator 에서 검증
        assertTrue(seqCheck);
    
    }
}
