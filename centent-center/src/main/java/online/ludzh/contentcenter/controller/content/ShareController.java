package online.ludzh.contentcenter.controller.content;

import lombok.RequiredArgsConstructor;
import online.ludzh.contentcenter.domain.dto.content.ShareDTO;
import online.ludzh.contentcenter.service.content.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mi-ludzh on 0003 2019/11/3.
 */
@RestController
@RequestMapping("shares")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareController {

    private final ShareService shareService;

    @GetMapping("/{id}")
    public ShareDTO findById(@PathVariable Integer id){
        return shareService.findById(id);
    }
}
