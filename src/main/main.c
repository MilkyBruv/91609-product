#include <stdio.h>
#include <allegro5/allegro.h>
#include <allegro5/allegro_image.h>
#include <allegro5/allegro_primitives.h>

#define min(a, b) (((a) < (b)) ? (a) : (b))

typedef struct ALM_RECTANGLE
{

    int x;
    int y;
    int width;
    int height;

} ALM_RECTANGLE;

bool alm_rectangles_collided(ALM_RECTANGLE rect1, ALM_RECTANGLE rect2)
{

    if (rect1.x < rect2.x + rect2.width - 1 && rect1.x + rect1.width - 1 > rect2.x &&
        rect1.y < rect2.y + rect2.height - 1 && rect1.y + rect1.height - 1 > rect2.y)
    {

        return true;

    }

    return false;

}

int main(int argc, char const *argv[])
{

    bool running = true;
    float scale_x = 1;
    float scale_y = 1;
    float scale = 1;
    float new_width = 128;
    float new_height = 72;
    float new_x = 0;
    float new_y = 0;
    int cc = 1;

    al_init();
    al_init_primitives_addon();
    al_install_keyboard();

    al_set_new_display_flags(ALLEGRO_WINDOWED | ALLEGRO_RESIZABLE);

    ALLEGRO_DISPLAY* display = al_create_display(1280, 720);

    ALLEGRO_EVENT_QUEUE* event_queue = al_create_event_queue();
    ALLEGRO_TIMER* timer = al_create_timer(1.0 / 60);
    
    al_register_event_source(event_queue, al_get_keyboard_event_source());
    al_register_event_source(event_queue, al_get_display_event_source(display));
    al_register_event_source(event_queue, al_get_timer_event_source(timer));

    al_set_window_title(display, "Inner Display Scale Test");

    ALM_RECTANGLE rect1;
    ALM_RECTANGLE rect2;

    rect1.x = 0;
    rect1.y = 0;
    rect1.width = 11;
    rect1.height = 11;

    rect2.x = 0;
    rect2.y = 0;
    rect2.width = 11;
    rect2.height = 11;

    al_init_image_addon();
    ALLEGRO_BITMAP* image = al_load_bitmap("./src/main/testimage.jpg");

    ALLEGRO_BITMAP* inner_display = al_create_bitmap(128, 72);
    al_set_target_bitmap(inner_display);
    al_clear_to_color(al_map_rgb(0, 0, 255));
    al_set_target_bitmap(al_get_backbuffer(display));

    al_start_timer(timer);

    while (running)
    {

        ALLEGRO_EVENT event;
        al_wait_for_event(event_queue, &event);

        if (alm_rectangles_collided(rect1, rect2))
        {
            
            cc = 0;

        } else
        {

            cc = 1;

        }

        if (event.type == ALLEGRO_EVENT_DISPLAY_RESIZE)
        {

            al_acknowledge_resize(display);

            al_clear_to_color(al_map_rgb(0, 0, 0));

        }

        if (event.type == ALLEGRO_EVENT_DISPLAY_CLOSE)
        {

            running = false;

        }

        if (event.type == ALLEGRO_EVENT_KEY_UP)
        {

            if (event.keyboard.keycode == ALLEGRO_KEY_ESCAPE)
            {

                running = false;

            }

            if (event.keyboard.keycode == ALLEGRO_KEY_LEFT)
            {

                rect1.x -= 1;

            }

            if (event.keyboard.keycode == ALLEGRO_KEY_RIGHT)
            {

                rect1.x += 1;

            }

            if (event.keyboard.keycode == ALLEGRO_KEY_UP)
            {

                rect1.y -= 1;

            }

            if (event.keyboard.keycode == ALLEGRO_KEY_DOWN)
            {

                rect1.y += 1;

            }

        }

        if (event.type == ALLEGRO_EVENT_TIMER)
        {

            al_set_target_bitmap(inner_display);

                al_clear_to_color(al_map_rgb(0, 0, 255 * cc));
                al_draw_scaled_bitmap(image, 0, 0, 100, 100, rect1.x, rect1.y, 10, 10, 0);
                al_draw_scaled_bitmap(image, 0, 0, 100, 100, rect2.x, rect2.y, 10, 10, 0);

            al_set_target_bitmap(al_get_backbuffer(display));

            scale_x = (float) al_get_display_width(display) / 128;
            scale_y = (float) al_get_display_height(display) / 72;
            scale = min(scale_x, scale_y);
            new_width = 128 * scale;
            new_height = 72 * scale;
            new_x = (al_get_display_width(display) / 2) - (new_width / 2);
            new_y = (al_get_display_height(display) / 2) - (new_height / 2);

            al_draw_scaled_bitmap(inner_display, 0, 0, 128, 72, new_x, new_y, new_width, new_height, 0);

            al_flip_display();

        }

    }
        
    al_destroy_display(display);
    al_destroy_bitmap(image);
    al_destroy_bitmap(inner_display);
    al_uninstall_keyboard();
    al_destroy_timer(timer);

    return 0;

}
