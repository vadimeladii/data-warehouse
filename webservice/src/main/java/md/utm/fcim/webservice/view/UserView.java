package md.utm.fcim.webservice.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserView implements Serializable {

    private static final long serialVersionUID = 4022451271475123464L;

    private Long id;
}
